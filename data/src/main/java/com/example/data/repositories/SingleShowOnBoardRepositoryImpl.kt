package com.example.data.repositories

import com.example.data.local.helper.OnBoardPreferencesHelper
import com.example.domain.repositories.SingleShowLogInRepository
import com.example.domain.repositories.SingleShowOnBoardRepository
import javax.inject.Inject

class SingleShowOnBoardRepositoryImpl @Inject constructor(
    private val onBoardPreferencesHelper: OnBoardPreferencesHelper
) : SingleShowOnBoardRepository {

    override var showOnBoard: Boolean
        get() = onBoardPreferencesHelper.showOnBoard
        set(value) {
            onBoardPreferencesHelper.showOnBoard = value
        }
}