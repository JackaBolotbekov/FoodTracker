package com.example.presentation.ui.fragments.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecases.SingleShowLogInUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.model.FirebaseHistoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val singleShowLogInUseCase: SingleShowLogInUseCase
) : BaseViewModel() {

    private val _noteLiveData2 = MutableLiveData<MutableList<FirebaseHistoryModel>>()
    val noteLiveData: LiveData<MutableList<FirebaseHistoryModel>> = _noteLiveData2
    private val noteList2 = mutableListOf<FirebaseHistoryModel>()

    fun setModels(list: MutableList<FirebaseHistoryModel>) {
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