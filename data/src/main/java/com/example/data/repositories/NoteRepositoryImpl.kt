package com.example.data.repositories

import com.example.domain.repositories.NoteRepository
import com.example.domain.usecases.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val db: FirebaseFirestore) : NoteRepository {

    private val messagesCollectionRef = db.collection("home")

    override suspend fun deleteMessageById(id: String): Resource<Unit> {
        return try {
            messagesCollectionRef.document(id).delete().await()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(
                e.localizedMessage ?: "An error occurred while deleting message with id=$id"
            )
        }
    }
}
