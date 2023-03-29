package com.example.presentation.ui.fragments.login

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLogInBinding

class LogInFragment : BaseFragment<FragmentLogInBinding, LogInViewModel>(R.layout.fragment_log_in) {

    override val binding by viewBinding(FragmentLogInBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {
    }
}