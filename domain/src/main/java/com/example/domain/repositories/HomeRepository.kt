package com.example.domain.repositories

import com.example.domain.models.FirebaseModel

interface HomeRepository {
    suspend fun getHomeData(): List<FirebaseModel>
}