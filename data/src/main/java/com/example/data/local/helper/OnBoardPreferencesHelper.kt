package com.example.data.local.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.data.constants.KEY_LOG_IN
import com.example.data.constants.KEY_NAME
import com.example.data.constants.SHARED_PREFS_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnBoardPreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    var showOnBoard: Boolean
        get() = preferences.getBoolean(KEY_LOG_IN, false)
        set(value) = preferences.edit().putBoolean(KEY_LOG_IN, value).apply()
}
