package com.example.domain.repositories

interface AddProductRepository {
    suspend fun saveUser(textTitle: String, numberKcal: String, timeText: String, id: String)
}