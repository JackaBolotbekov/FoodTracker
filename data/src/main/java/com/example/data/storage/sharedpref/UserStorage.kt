package com.example.data.storage.sharedpref

import com.example.data.storage.model.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}