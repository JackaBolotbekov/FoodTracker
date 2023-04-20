package com.example.presentation.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.local.dtos.NoteDto
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel(){

    private val _noteLiveData2 = MutableLiveData<MutableList<NoteDto>>()
    val noteLiveData2: LiveData<MutableList<NoteDto>> = _noteLiveData2
    private val noteList2 = mutableListOf<NoteDto>()

    fun setModels2(list: MutableList<NoteDto>) {
        noteList2.clear()
        noteList2.addAll(list)
        _noteLiveData2.value = noteList2.toMutableList()
    }

    private val _noteLiveData = MutableLiveData<MutableList<NoteDto>>()
    val noteLiveData: LiveData<MutableList<NoteDto>> = _noteLiveData
    private var noteList = mutableListOf<NoteDto>()
    fun setModels(message: String, time: String) {
        noteList.add(NoteDto(message = message, time = time))
        _noteLiveData.value = noteList.toMutableList()
    }
}