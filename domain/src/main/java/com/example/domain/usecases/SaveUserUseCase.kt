package com.example.domain.usecases

import com.example.domain.repositories.AddProductRepository
import javax.inject.Inject

class SaveUserUseCase  @Inject constructor(
    private val addProductRepository: AddProductRepository
) {

    suspend fun saveUser(textTitle: String, numberKcal: String, timeText: String, id: String) {
        addProductRepository.saveUser(textTitle, numberKcal, timeText, id)
    }
}