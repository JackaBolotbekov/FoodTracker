package com.example.data.repositories

import android.content.ContentValues.TAG
import android.util.Log
import com.example.domain.repositories.AddProductRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddProductRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
) : AddProductRepository {

    override suspend fun saveUser(
        textTitle: String,
        numberKcal: String,
        timeText: String,
        id: String,
    ) {
        val collectionRef = db.collection("home")
        val newDocRef = collectionRef.document()
        val user = hashMapOf(
            "text" to textTitle, "message" to numberKcal, "time" to timeText, "id" to newDocRef.id
        )
        db.collection("home").document().set(user).await()
        newDocRef.set(user)
            .addOnSuccessListener {
                Log.d(TAG, "Данные успешно записаны в Firestore")
            }
            .addOnFailureListener {
                Log.d(TAG, "Ошибка записи данных в Firestore: $it")
            }
    }
}
