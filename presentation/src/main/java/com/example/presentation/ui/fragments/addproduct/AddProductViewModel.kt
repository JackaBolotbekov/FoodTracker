package com.example.presentation.ui.fragments.addproduct

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.SaveUserUseCase
import javax.inject.Inject
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val addProductUseCase: SaveUserUseCase
) : BaseViewModel() {

    fun saveUser(textTitle: String, numberKcal: String, timeText: String, id: String) {
        viewModelScope.launch {
            addProductUseCase.saveUser(textTitle, numberKcal, timeText, id)
        }
    }
}