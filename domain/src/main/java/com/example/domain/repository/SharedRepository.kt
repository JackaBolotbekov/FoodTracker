package com.example.domain.repository

import com.example.domain.models.SaveUserParams
import com.example.domain.models.UserParams

interface SharedRepository {

    fun saveName(saveParam: SaveUserParams): Boolean

    fun getName(): UserParams
}