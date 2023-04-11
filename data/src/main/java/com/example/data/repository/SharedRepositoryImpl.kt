package com.example.data.repository

import com.example.data.storage.model.User
import com.example.data.storage.sharedpref.UserStorage
import com.example.domain.models.SaveUserParams
import com.example.domain.models.UserParams
import com.example.domain.repository.SharedRepository

class SharedRepositoryImpl (private val userStorage: UserStorage) : SharedRepository {

    override fun saveName(saveParam: SaveUserParams): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserParams {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserParams): User {
        return User(nameLogIn = saveParam.nameLogIn, booleanOnBoard = saveParam.booleanOnBoard, booleanLogIn = saveParam.booleanLogIn)
    }

    private fun mapToDomain(user: User) : UserParams {
        return UserParams(nameLogIn = user.nameLogIn, booleanOnBoard = user.booleanOnBoard, booleanLogIn = user.booleanLogIn)
    }
}