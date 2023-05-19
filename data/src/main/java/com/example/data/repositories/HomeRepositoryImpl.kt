package com.example.data.repositories

import com.example.domain.models.FirebaseModel
import com.example.domain.repositories.HomeRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
) : HomeRepository {

    override suspend fun getHomeData(): List<FirebaseModel> {
        val snapshot = db.collection("home").orderBy("time", Query.Direction.ASCENDING).get().await()
        return snapshot.toObjects(FirebaseModel::class.java)
    }
}