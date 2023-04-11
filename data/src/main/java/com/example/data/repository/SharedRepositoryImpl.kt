package com.example.data.repository

import android.content.SharedPreferences
import com.example.domain.repository.SharedRepository
import javax.inject.Inject

class SharedRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SharedRepository{

    override fun saveData(KEY_NAME: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(KEY_NAME, value)
        editor.apply()
    }

    override fun getData(KEY_NAME: String): Boolean {
        return sharedPreferences.getBoolean(KEY_NAME, false)
    }
}