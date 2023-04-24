package com.example.presentation.ui.fragments.login


import com.example.domain.usecases.SaveUserParamsUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val saveUserParamsUseCase: SaveUserParamsUseCase
): BaseViewModel() {

    fun saveData(key: String, value: Boolean) = saveUserParamsUseCase.saveData(key, value)

    fun getData(key: String) = saveUserParamsUseCase.getData(key)
}