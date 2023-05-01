package com.example.presentation.ui.activity

import com.example.domain.usecases.SingleShowLogInUseCase
import com.example.domain.usecases.SingleShowOnBoardUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase,
    private val singleShowOnBoardUseCase: SingleShowOnBoardUseCase
) : BaseViewModel() {

    var showLogIn: Boolean
        get() = singleShowLogInUseCase.showLogIn
        set(value) {
            singleShowLogInUseCase.showLogIn = value
        }

    var showOnBoard: Boolean
        get() = singleShowOnBoardUseCase.showOnBoard
        set(value) {
            singleShowOnBoardUseCase.showOnBoard = value
        }
}