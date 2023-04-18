package com.example.data.repositories

import android.content.SharedPreferences
import com.example.domain.repositories.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : UserInfoRepository {

    override fun saveData(key: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    override fun getData(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}