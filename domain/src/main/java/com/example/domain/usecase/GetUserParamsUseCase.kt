package com.example.domain.usecase

import com.example.domain.models.UserParams
import com.example.domain.repository.SharedRepository

class GetUserParamsUseCase(private val userRepository: SharedRepository) {

    fun execute(): UserParams {
        return userRepository.getName()
    }
}