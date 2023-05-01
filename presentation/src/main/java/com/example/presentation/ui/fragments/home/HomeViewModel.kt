package com.example.presentation.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecases.SingleShowLogInUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.model.FirebaseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase
) : BaseViewModel() {

    private val _noteLiveData2 = MutableLiveData<MutableList<FirebaseModel>>()
    val noteLiveData2: LiveData<MutableList<FirebaseModel>> = _noteLiveData2

    private val noteList2 = mutableListOf<FirebaseModel>()

    fun setModels2(list: MutableList<FirebaseModel>) {
        noteList2.clear()
        noteList2.addAll(list)
        _noteLiveData2.value = noteList2.toMutableList()
    }

    var userName: String?
        get() = singleShowLogInUseCase.userName
        set(value) {
            singleShowLogInUseCase.userName = value
        }
}