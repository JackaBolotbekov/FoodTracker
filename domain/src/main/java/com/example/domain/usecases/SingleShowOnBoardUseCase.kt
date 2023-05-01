package com.example.domain.usecases

import com.example.domain.repositories.SingleShowOnBoardRepository
import javax.inject.Inject

class SingleShowOnBoardUseCase @Inject constructor(
    private val singleShowOnBoardRepository: SingleShowOnBoardRepository
) {

    var showOnBoard: Boolean
        get() = singleShowOnBoardRepository.showOnBoard
        set(value) {
            singleShowOnBoardRepository.showOnBoard = value
        }
}