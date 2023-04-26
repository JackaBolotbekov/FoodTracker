package com.example.data.repositories

import com.example.data.local.helper.LogInPreferencesHelper
import com.example.domain.repositories.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val preferencesHelper: LogInPreferencesHelper
) : UserInfoRepository {

    override var showLogIn: Boolean
        get() = preferencesHelper.showLogIn
        set(value) {
            preferencesHelper.showLogIn = value
        }

    override var logInText: String?
        get() = preferencesHelper.logInText
        set(value) {
            preferencesHelper.logInText = value
        }
}