package com.example.presentation.ui.fragments.history

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHistoryBinding
import com.example.presentation.model.FirebaseHistoryModel
import com.example.presentation.ui.adapter.HistoryAdapter
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HistoryFragment :
    BaseFragment<FragmentHistoryBinding, HistoryViewModel>(R.layout.fragment_history) {

    override val binding by viewBinding(FragmentHistoryBinding::bind)
    override val viewModel: HistoryViewModel by viewModels()
    private val historyAdapter = HistoryAdapter()
    private val db = Firebase.firestore

    override fun initialize() {
        binding.rvHistory.adapter = historyAdapter
        getMessage()
    }

    private fun getMessage() {
        viewModel.userName?.let { userName ->
            db.collection(userName + "_history").document().addSnapshotListener { _, _ ->
                val f =
                    db.collection(userName + "_history").orderBy("date", Query.Direction.DESCENDING)
                        .get()
                f.addOnSuccessListener { data ->
                    val message = data.toObjects(FirebaseHistoryModel::class.java)
                    viewModel.setModels(message)
                }
                viewModel.viewModelScope.launch {
                    viewModel.noteLiveData.observe(viewLifecycleOwner) {
                        historyAdapter.submitList(it)
                    }
                }
            }
        }
    }
}
