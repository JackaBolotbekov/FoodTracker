package com.example.presentation.ui.fragments.login


import com.example.domain.usecases.SaveUserParamsUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val saveUserParamsUseCase: SaveUserParamsUseCase
) : BaseViewModel() {

    var showLogIn: Boolean
        get() = saveUserParamsUseCase.showLogIn
        set(value) {
            saveUserParamsUseCase.showLogIn = value
        }
}