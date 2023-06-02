package com.example.presentation.ui.activity

import com.example.domain.usecases.SaveDefaultKcalUseCase
import com.example.domain.usecases.SingleShowLogInUseCase
import com.example.domain.usecases.SingleShowOnBoardUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase,
    private val singleShowOnBoardUseCase: SingleShowOnBoardUseCase,
    private val saveDefaultKcalUseCase: SaveDefaultKcalUseCase
) : BaseViewModel() {

    var showLogIn: Boolean
        get() = singleShowLogInUseCase.showLogIn
        set(value) {
            singleShowLogInUseCase.showLogIn = value
        }

    var userName: String?
        get() = singleShowLogInUseCase.userName
        set(value) {
            singleShowLogInUseCase.userName = value
        }

    var showOnBoard: Boolean
        get() = singleShowOnBoardUseCase.showOnBoard
        set(value) {
            singleShowOnBoardUseCase.showOnBoard = value
        }

    var defaultKcalText: String?
        get() = saveDefaultKcalUseCase.defaultKcalText
        set(value) {
            saveDefaultKcalUseCase.defaultKcalText = value
        }

    var progressKcal: Int
        get() = saveDefaultKcalUseCase.progressKcal
        set(value) {
            saveDefaultKcalUseCase.progressKcal = value
        }
}