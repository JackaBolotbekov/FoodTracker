package com.example.domain.usecases

import com.example.domain.repositories.UserInfoRepository
import javax.inject.Inject

class SaveUserParamsUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {

    fun saveData(key: String, value: Boolean) = userInfoRepository.saveData(key, value)

    fun getData(key: String) = userInfoRepository.getData(key)
}