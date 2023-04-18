package com.example.presentation.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.presentation.ui.fragments.onboard.OnBoardPagerFragment
import com.example.presentation.ui.fragments.onboard.OnBoardPagerFragment.Companion.KEY

class OnBoardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(KEY, position)
        }
    }
}
