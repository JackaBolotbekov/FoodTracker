package com.example.presentation.ui.fragments.onboard


import com.example.domain.usecases.SingleShowOnBoardUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val singleShowOnBoardUseCase: SingleShowOnBoardUseCase
) : BaseViewModel() {

    var showOnBoard: Boolean
        get() = singleShowOnBoardUseCase.showOnBoard
        set(value) {
            singleShowOnBoardUseCase.showOnBoard = value
        }
}