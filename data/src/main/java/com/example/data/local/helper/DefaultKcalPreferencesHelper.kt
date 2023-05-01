package com.example.data.local.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.data.constants.KEY_DEFAULT_KCAL
import com.example.data.constants.KEY_PROGRESS_KCAL
import com.example.data.constants.SHARED_PREFS_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultKcalPreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    var defaultKcal: String?
        get() = preferences.getString(KEY_DEFAULT_KCAL, "0")
        set(value) = preferences.edit().putString(KEY_DEFAULT_KCAL, value).apply()

    var progressKcal: Int
        get() = preferences.getInt(KEY_PROGRESS_KCAL, 0)
        set(value) = preferences.edit().putInt(KEY_PROGRESS_KCAL, value).apply()
}