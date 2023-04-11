package com.example.domain.repository

interface SharedRepository {

    fun saveData(KEY_NAME: String, value : Boolean)

    fun getData(KEY_NAME: String) : Boolean

}