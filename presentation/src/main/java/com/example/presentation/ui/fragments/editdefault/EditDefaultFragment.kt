package com.example.presentation.ui.fragments.editdefault

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHistoryBinding
import com.example.presentation.ui.fragments.history.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditDefaultFragment :
    BaseFragment<FragmentHistoryBinding, HistoryViewModel>(R.layout.fragment_edit_default) {

    override val binding by viewBinding(FragmentHistoryBinding::bind)
    override val viewModel: HistoryViewModel by viewModels()
}