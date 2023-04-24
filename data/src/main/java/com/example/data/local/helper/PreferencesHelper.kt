package com.example.data.local.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.data.constants.KEY_LOG_IN
import com.example.data.constants.KEY_NAME
import com.example.data.constants.SHARED_PREFS_NAME

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    var showLogIn: Boolean
        get() = preferences.getBoolean(KEY_LOG_IN, false)
        set(value) = preferences.edit().putBoolean("geeks", value).apply()

    var logInText: String?
        get() = preferences.getString(KEY_NAME, "")
        set(value) = preferences.edit().putString("studio", value).apply()

}
