package com.example.foodtracker

import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {

    private lateinit var preferences: SharedPreferences

    fun unit (context: Context){
        preferences = context.getSharedPreferences("onBoard", Context.MODE_PRIVATE)
    }

    var showOnBoard: Boolean
        get() = preferences.getBoolean("geeks", false)
        set(value) = preferences.edit().putBoolean("geeks", value).apply()

    var logInText: String?
        get() = preferences.getString("studio", "")
        set(value) = preferences.edit().putString("studio", value).apply()
}
