package com.example.domain.usecases

import com.example.domain.repositories.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend fun deleteMessageById(id: String): Resource<Unit> {
        return repository.deleteMessageById(id)
    }
}