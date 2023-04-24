package com.example.presentation.model

import com.example.domain.models.SaveUserParams

data class SaveUserParamsUI(
    val nameLogIn: String,
    val booleanOnBoard: Boolean,
    val booleanLogIn: Boolean
)

fun SaveUserParams.toUI() =
    SaveUserParamsUI(nameLogIn, booleanOnBoard, booleanLogIn)
