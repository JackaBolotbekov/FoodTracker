//package com.example.data.storage.sharedpref
//
//import android.content.Context
//import com.example.data.KEY_LOG_IN
//import com.example.data.KEY_NAME
//import com.example.data.KEY_ON_BOARD
//import com.example.data.SHARED_PREFS_NAME
//import com.example.data.storage.dtos.SaveUserParamsDto
//
//class SharedPrefUserStorage(context: Context) : UserStorage {
//
//    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
//
//    override fun get(): SaveUserParamsDto {
//        val nameLogIn = sharedPreferences.getString(KEY_NAME, "b") ?: "B"
//        val booleanOnBoard = sharedPreferences.getBoolean(KEY_ON_BOARD, false)
//        val booleanLogIn = sharedPreferences.getBoolean(KEY_LOG_IN, false)
//        return SaveUserParamsDto (nameLogIn = nameLogIn, booleanOnBoard = booleanOnBoard, booleanLogIn = booleanLogIn)
//    }
//
//    override fun save(saveUserParamsDto: SaveUserParamsDto): Boolean {
//        sharedPreferences.edit().putString(KEY_NAME, saveUserParamsDto.nameLogIn).apply()
//        sharedPreferences.edit().putBoolean(KEY_ON_BOARD, saveUserParamsDto.booleanOnBoard).apply()
//        sharedPreferences.edit().putBoolean(KEY_LOG_IN, saveUserParamsDto.booleanLogIn).apply()
//        return true
//    }
//}