package com.example.presentation.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.models.FirebaseModel
import com.example.domain.usecases.DeleteNoteUseCase
import com.example.domain.usecases.GetHomeDataUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.model.FirebaseModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: GetHomeDataUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
    ) : BaseViewModel() {

    private val _homeData = MutableLiveData<List<FirebaseModel>>()
    val homeData: LiveData<List<FirebaseModel>> = _homeData


    private val _noteLiveData2 = MutableLiveData<MutableList<FirebaseModel>>()
    val noteLiveData2: LiveData<MutableList<FirebaseModel>> = _noteLiveData2

    private val noteList2 = mutableListOf<FirebaseModel>()

    fun setModels2(list: MutableList<FirebaseModel>) {
        noteList2.clear()
        noteList2.addAll(list)
        _noteLiveData2.value = noteList2.toMutableList()
    }

    fun deleteMessage(id: String) {
        viewModelScope.launch {
            deleteNoteUseCase.deleteMessageById(id)
        }
    }

    fun loadData() {
        viewModelScope.launch {
            _homeData.value = homeUseCase.getHomeData()
        }
    }
}