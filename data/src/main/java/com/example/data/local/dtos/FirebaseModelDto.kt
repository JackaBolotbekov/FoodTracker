package com.example.data.local.dtos

import com.example.domain.models.FirebaseModel

data class FirebaseModelDto(
    val message: String? = null,
    val time: String? = null,
    val text: String? = null
)
fun FirebaseModelDto.toDomain() =
    FirebaseModel(message, time, text)
