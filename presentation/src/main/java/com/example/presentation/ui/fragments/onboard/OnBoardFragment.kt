package com.example.presentation.ui.fragments.onboard

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentOnBoardBinding
import com.example.presentation.ui.adapter.OnBoardPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : BaseFragment<FragmentOnBoardBinding, OnBoardViewModel>(R.layout.fragment_on_board) {

    override val binding by viewBinding(FragmentOnBoardBinding::bind)
    override val viewModel: OnBoardViewModel by viewModels()

    override fun initialize() {
        initial()
    }

    override fun setupListeners() {
        setupListener()
    }

    private fun initial() = with(binding.viewPager) {
        adapter = OnBoardPagerAdapter(this@OnBoardFragment)
        TabLayoutMediator(binding.tabLayout, this) { _, _ -> }.attach()
    }

    private fun setupListener() = with(binding) {
        btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_pagerFragment_to_logInFragment)
            viewModel.showOnBoard = true
        }
    }
}
