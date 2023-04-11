package com.example.presentation.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
//import com.example.foodtracker.PreferencesHelper
import com.example.presentation.R
import com.example.presentation.databinding.FragmentOnBoardBinding
import com.example.presentation.ui.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : Fragment(R.layout.fragment_on_board) {

    private lateinit var binding : FragmentOnBoardBinding
    private lateinit var helper : FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() = with(binding.viewPager) {
        adapter = PagerAdapter(this@OnBoardFragment)
//        PreferencesHelper.unit(requireContext())
    }

    private fun setupListeners() = with(binding) {
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->
        }.attach()

        btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_pagerFragment_to_logInFragment)
//            PreferencesHelper.showOnBoard = true
        }
    }
}
