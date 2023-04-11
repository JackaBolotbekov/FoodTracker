package com.example.presentation.ui.fragments.login


import com.example.domain.usecase.SaveUserParamsUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.model.SaveUserParamsUI
import com.example.presentation.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val saveUserParamsUseCase: SaveUserParamsUseCase
): BaseViewModel() {

    fun saveData(key: String, value: Boolean) = saveUserParamsUseCase.saveData(key, value)

    fun getData(key: String) = saveUserParamsUseCase.getData(key)
}