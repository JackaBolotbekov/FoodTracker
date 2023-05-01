package com.example.presentation.ui.fragments.login


import com.example.domain.usecases.SingleShowLogInUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase
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
}