package com.example.presentation.ui.fragments.onboard.pager

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentPagerBinding
import com.example.presentation.ui.adapter.PagerAdapter
import com.example.presentation.ui.fragments.login.LogInViewModel
import com.google.android.material.tabs.TabLayoutMediator

class PagerFragment : BaseFragment<FragmentPagerBinding, LogInViewModel>(R.layout.fragment_pager) {

    override val binding by viewBinding(FragmentPagerBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun initialize() = with(binding.viewPager) {
        adapter = PagerAdapter(this@PagerFragment)
    }

    override fun setupListeners() = with(binding) {
        btnSkip.setOnClickListener {
            if (viewPager.currentItem < 3)
                viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
        }.attach()
    }
}