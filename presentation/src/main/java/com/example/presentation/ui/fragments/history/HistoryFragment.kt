package com.example.presentation.ui.fragments.history

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment :
    BaseFragment<FragmentHistoryBinding, HistoryViewModel>(R.layout.fragment_history) {

    override val binding by viewBinding(FragmentHistoryBinding::bind)
    override val viewModel: HistoryViewModel by viewModels()
//    private lateinit var homeAdapter: HomeAdapter
//
//    override fun initialize() = with(binding) {
//        rvHistory.adapter = homeAdapter
//    }
}