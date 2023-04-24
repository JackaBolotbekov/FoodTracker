package com.example.presentation.ui.fragments.onboard

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentOnBoardPagerBinding
import com.example.presentation.ui.fragments.login.LogInViewModel

class OnBoardPagerFragment :
    BaseFragment<FragmentOnBoardPagerBinding, LogInViewModel>(R.layout.fragment_on_board_pager) {

    override val binding by viewBinding(FragmentOnBoardPagerBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun setupSubscribes() {
        subscribePosition()
    }

    private fun subscribePosition() = with(binding) {
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
