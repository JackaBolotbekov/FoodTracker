package com.example.presentation.ui.fragments.addproduct

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAddProductBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddProductFragment :
    BaseFragment<FragmentAddProductBinding, AddProductViewModel>(R.layout.fragment_add_product) {

    override val binding by viewBinding(FragmentAddProductBinding::bind)
    override val viewModel: AddProductViewModel by viewModels()

    override fun setupListeners() {
        binding.swoosh.setOnClickListener {
            val message = binding.etProduct.text.toString()
            if (message.isEmpty()) {
                Toast.makeText(requireContext(), "Введите текст...", Toast.LENGTH_SHORT).show()
            } else if (message == "/report") {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            } else {
                sendMessage()
            }
        }
    }

    override fun setupObserves() {
        binding.btnSave.setOnClickListener {
            val message = binding.etProduct.text.toString()
            if (message.isEmpty()) {
                Toast.makeText(requireContext(), "Введите текст...", Toast.LENGTH_SHORT).show()
            } else if (message == "/report") {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            } else {
                sendMessage()
            }
        }
    }

    private fun sendMessage() {
        val formatterUse = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        val time = formatterUse.format(Date())
        val timeText = time.toString()
        val numberKcal = binding.etCcal.text.toString()
        val textTitle = binding.etProduct.text.toString()
        viewModel.saveUser(textTitle, numberKcal, timeText, id.toString())
        findNavController().navigateUp()
    }
}