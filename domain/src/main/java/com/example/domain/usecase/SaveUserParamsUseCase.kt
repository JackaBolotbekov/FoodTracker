package com.example.domain.usecase

import com.example.domain.models.SaveUserParams
import com.example.domain.repository.SharedRepository

class SaveUserParamsUseCase(private val userRepository: SharedRepository) {

    fun execute(params: SaveUserParams): Boolean {
        return userRepository.saveName(saveParam = params)
    }
}