package com.example.domain.usecases

import com.example.domain.repositories.SingleShowLogInRepository
import javax.inject.Inject

class SingleShowLogInUseCase @Inject constructor(
    private val singleShowLogInRepository: SingleShowLogInRepository
) {

    var showLogIn: Boolean
        get() = singleShowLogInRepository.showLogIn
        set(value) {
            singleShowLogInRepository.showLogIn = value
        }

    var userName: String?
        get() = singleShowLogInRepository.logInText
        set(value) {
            singleShowLogInRepository.logInText = value
        }
}