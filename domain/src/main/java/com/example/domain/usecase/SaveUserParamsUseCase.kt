package com.example.domain.usecase

import com.example.domain.repository.SharedRepository
import javax.inject.Inject

class SaveUserParamsUseCase @Inject constructor(
    private val sharedRepository: SharedRepository
) {

    fun saveData(key: String, value: Boolean)
    = sharedRepository.saveData(key, value)

    fun getData(key: String) = sharedRepository.getData(key)
}