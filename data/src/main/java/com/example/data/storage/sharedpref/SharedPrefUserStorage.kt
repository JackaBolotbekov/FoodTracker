package com.example.data.storage.sharedpref

import android.content.Context
import com.example.data.*
import com.example.data.KEY_LOG_IN
import com.example.data.KEY_NAME
import com.example.data.KEY_ON_BOARD
import com.example.data.SHARED_PREFS_NAME
import com.example.data.storage.model.User

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun get(): User {
        val nameLogIn = sharedPreferences.getString(KEY_NAME, "b") ?: "B"
        val booleanOnBoard = sharedPreferences.getBoolean(KEY_ON_BOARD, false)
        val booleanLogIn = sharedPreferences.getBoolean(KEY_LOG_IN, false)
        return User (nameLogIn = nameLogIn, booleanOnBoard = booleanOnBoard, booleanLogIn = booleanLogIn)
    }

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, user.nameLogIn).apply()
        sharedPreferences.edit().putBoolean(KEY_ON_BOARD, user.booleanOnBoard).apply()
        sharedPreferences.edit().putBoolean(KEY_LOG_IN, user.booleanLogIn).apply()
        return true
    }
}