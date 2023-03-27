package com.example.foodtracker.ui.fragments.onboard.pager

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodtracker.R

class PagerFragment : Fragment() {

    companion object {
        fun newInstance() = PagerFragment()
    }

    private lateinit var viewModel: PagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PagerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}