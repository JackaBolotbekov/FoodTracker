package com.example.data.repositories

import com.example.data.local.helper.LogInPreferencesHelper
import com.example.domain.repositories.SingleShowLogInRepository
import javax.inject.Inject

class SingleShowLogInRepositoryImpl @Inject constructor(
    private val logInPreferencesHelper: LogInPreferencesHelper
) : SingleShowLogInRepository {

    override var showLogIn: Boolean
        get() = logInPreferencesHelper.showLogIn
        set(value) {
            logInPreferencesHelper.showLogIn = value
        }

    override var logInText: String?
        get() = logInPreferencesHelper.logInText
        set(value) {
            logInPreferencesHelper.logInText = value
        }
}