package com.example.domain.repositories

import com.example.domain.usecases.Resource

interface NoteRepository {
    suspend fun deleteMessageById(id: String): Resource<Unit>
}
