package com.example.presentation.ui.activity

import com.example.domain.usecases.SaveUserParamsUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveUserParamsUseCase: SaveUserParamsUseCase
): BaseViewModel() {

    fun getData(key: String) = saveUserParamsUseCase.getData(key)
}