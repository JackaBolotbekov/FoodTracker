package com.example.presentation.ui.fragments.editdefault

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentEditDefaultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditDefaultFragment :
    BaseFragment<FragmentEditDefaultBinding, EditDefaultViewModel>(R.layout.fragment_edit_default) {

    override val binding by viewBinding(FragmentEditDefaultBinding::bind)
    override val viewModel: EditDefaultViewModel by viewModels()

    override fun setupObserves() {
        setUpListener()
    }

    private fun setUpListener() = with(binding) {
        swoosh.setOnClickListener {
            val text = etEditNormsDay.text.toString().trim()
            if (text.length < 5) {
                viewModel.defaultKcalText = text
                Log.d("setDefaultKcal", text)
                findNavController().navigateUp()
            } else {etEditNormsDay.error = "Вы явно переоцениваете свои возможности!"}
        }
    }
}