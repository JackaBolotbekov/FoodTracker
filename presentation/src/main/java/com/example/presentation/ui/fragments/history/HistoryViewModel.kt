package com.example.presentation.ui.fragments.history

import com.example.presentation.base.BaseViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor() :
    BaseViewModel() {

//    fun addStory(story: Story) {
//        db.collection("stories")
//            .add(story)
//            .addOnSuccessListener { documentReference ->
//                // Запись успешно добавлена
//            }
//            .addOnFailureListener { e ->
//                // Обработка ошибки
//            }
//    }
}