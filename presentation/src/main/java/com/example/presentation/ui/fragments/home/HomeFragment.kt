package com.example.presentation.ui.fragments.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    var progress = 0

    override fun initialize() {
        initial()
    }

    override fun setupListeners() {
        click()
    }

    private fun initial() = with(binding) {
        tvNumberCalories.setText(R.string.number_0)
    }

    private fun click() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
        btnEdit.setOnClickListener {
            if (progress >= 10) {
                progress -= 10
                updateProgressBar()
            }
        }
        btnHistory.setOnClickListener {
            if (progress <= 90) {
                progress += 10
                updateProgressBar()
            }
        }
    }

    fun updateProgressBar() = with(binding) {
        progressBar.progress = progress
        tvNumberCalories.text = progress.toString()
    }
}
