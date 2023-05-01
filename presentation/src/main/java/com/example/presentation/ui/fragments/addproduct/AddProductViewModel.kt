package com.example.presentation.ui.fragments.addproduct

import com.example.domain.usecases.SingleShowLogInUseCase
import javax.inject.Inject
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase
) : BaseViewModel() {

    var userName: String?
        get() = singleShowLogInUseCase.userName
        set(value) {
            singleShowLogInUseCase.userName = value
        }
}