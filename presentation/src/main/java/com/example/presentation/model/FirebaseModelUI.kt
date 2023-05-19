package com.example.presentation.model

import com.example.domain.models.FirebaseModel

data class FirebaseModelUI(
    val message: String? = null,
    val time: String? = null,
    val text: String? = null
)
fun FirebaseModel.toDomain() =
    FirebaseModelUI(message, time, text)
