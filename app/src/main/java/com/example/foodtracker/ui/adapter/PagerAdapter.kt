package com.example.foodtracker.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodtracker.ui.fragments.onboard.OnBoardFragment
import com.example.foodtracker.ui.fragments.onboard.OnBoardFragment.Companion.KEY
import com.example.foodtracker.ui.fragments.onboard.pager.PagerFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardFragment().apply {
        when(position){
            0-> OnBoardFragment()
            1-> PagerFragment()
        }
        arguments = Bundle().apply {
            putInt(KEY, position)
        }
    }
}