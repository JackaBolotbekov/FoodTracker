package com.example.presentation.ui.fragments._notifycation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun setAlarmService(username: String?, progress : Int) {

    val firestore = FirebaseFirestore.getInstance()
    val timestamp = Timestamp.now()
    val currentDate = LocalDate.now()
    val collectionRef = firestore.collection(username!!)
    collectionRef.orderBy("date", Query.Direction.DESCENDING).limit(1)
        .get()
        .addOnSuccessListener { documentSnapshot ->
            if (!documentSnapshot.isEmpty) {
                val documentSnapshots = documentSnapshot.documents[0]
                val storedDate = documentSnapshots.getDate("date")
                val storedLocalDate =
                    storedDate?.toInstant()?.atZone(ZoneId.systemDefault())?.toLocalDate()
                Log.d("time", "now = $currentDate")
                Log.d("time", "firebase = " + storedLocalDate.toString())

                // Сравнение даты и времени
                if (currentDate != storedLocalDate) {

                    val data = hashMapOf(
                        "calories" to progress.toString(),
                        "time" to storedLocalDate.toString(),
                        "date" to timestamp
                    )

                    firestore.collection(username + "_history")
                        .add(data)
                        .addOnSuccessListener { documentReference ->
                            // Документ успешно добавлен
                            val documentId = documentReference.id
                            Log.d("MyService", "Document added with ID: $documentId")
                            if (username != null) {
                                firestore.collection(username).get()
                                    .addOnSuccessListener { querySnapshot ->
                                        for (document in querySnapshot) {
                                            document.reference.delete()
                                        }
                                    }
                                    .addOnFailureListener { exception ->
                                        Log.d("failure", "Error getting documents HISTORY: ", exception)
                                    }
                            }
                        }
                        .addOnFailureListener { e ->
                            // Ошибка при добавлении документа
                            Log.e("MyService", "Error adding document", e)
                        }
                }
            }
        }
        .addOnFailureListener { exception ->
            Log.d("failure", "Error getting documents HISTORY: ", exception)
        }
}