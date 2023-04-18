package com.example.domain.repositories

interface UserInfoRepository {

    fun saveData(key: String, value: Boolean)

    fun getData(key: String): Boolean

}