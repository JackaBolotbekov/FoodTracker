package com.example.domain.usecases

import com.example.domain.models.FirebaseModel
import com.example.domain.repositories.HomeRepository
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(private val repository: HomeRepository) {

    suspend fun getHomeData(): List<FirebaseModel> = repository.getHomeData()
}
