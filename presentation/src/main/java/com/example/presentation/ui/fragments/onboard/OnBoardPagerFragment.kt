package com.example.presentation.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentOnBoardPagerBinding

class OnBoardPagerFragment : Fragment(R.layout.fragment_on_board_pager) {

    private lateinit var binding : FragmentOnBoardPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(KEY)) {
            0 -> {
                image.setImageResource(R.drawable.ob1)
                tvDescription.text = ""
                tvTitle.setText(R.string.first_title_on_board)
            }
            1 -> {
                tvDescription.setText(R.string.first_description_on_board)
                image.setImageResource(R.drawable.ob2)
                tvTitle.setText(R.string.second_title_on_board)
            }
            2 -> {
                tvDescription.setText(R.string.second_description_on_board)
                tvTitle.setText(R.string.third_title_on_board)
                image.setImageResource(R.drawable.ob3)
            }
        }
    }

    companion object {
        const val KEY = "onBoard"
    }
}
