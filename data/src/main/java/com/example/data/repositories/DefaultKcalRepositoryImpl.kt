package com.example.data.repositories

import com.example.data.local.helper.DefaultKcalPreferencesHelper
import com.example.data.local.helper.LogInPreferencesHelper
import com.example.domain.repositories.DefaultKcalRepository
import com.example.domain.repositories.SingleShowLogInRepository
import javax.inject.Inject

class DefaultKcalRepositoryImpl @Inject constructor(
    private val defaultKcalPreferencesHelper: DefaultKcalPreferencesHelper
) : DefaultKcalRepository {

    override var defaultKcalText: String?
        get() = defaultKcalPreferencesHelper.defaultKcal
        set(value) {
            defaultKcalPreferencesHelper.defaultKcal = value
        }
    override var progressKcal: Int
        get() = defaultKcalPreferencesHelper.progressKcal
        set(value) {
            defaultKcalPreferencesHelper.progressKcal = value
        }
}