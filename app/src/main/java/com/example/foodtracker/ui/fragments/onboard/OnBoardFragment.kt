package com.example.foodtracker.ui.fragments.onboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodtracker.R

class OnBoardFragment : Fragment() {

    companion object {
        fun newInstance() = OnBoardFragment()
    }

    private lateinit var viewModel: OnBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_board, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OnBoardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}