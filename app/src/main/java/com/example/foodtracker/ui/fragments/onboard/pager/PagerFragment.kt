package com.example.foodtracker.ui.fragments.onboard.pager

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.foodtracker.R
import com.example.foodtracker.base.BaseFragment
import com.example.foodtracker.databinding.FragmentPagerBinding
import com.example.foodtracker.ui.adapter.PagerAdapter
import com.example.foodtracker.ui.fragments.login.LogInViewModel
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