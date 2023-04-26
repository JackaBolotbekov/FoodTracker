package com.example.domain.usecases

import com.example.domain.repositories.UserInfoRepository
import javax.inject.Inject

class SaveUserParamsUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {

    var showLogIn: Boolean
        get() = userInfoRepository.showLogIn
        set(value) {
            userInfoRepository.showLogIn = value
        }
}