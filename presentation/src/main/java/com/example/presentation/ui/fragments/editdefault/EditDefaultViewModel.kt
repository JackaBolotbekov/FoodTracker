package com.example.presentation.ui.fragments.editdefault

import com.example.domain.usecases.SaveDefaultKcalUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditDefaultViewModel @Inject constructor(
    private val saveDefaultKcalUseCase: SaveDefaultKcalUseCase
): BaseViewModel() {

    var defaultKcalText: String?
        get() = saveDefaultKcalUseCase.defaultKcalText
        set(value) {
            saveDefaultKcalUseCase.defaultKcalText = value
        }
}