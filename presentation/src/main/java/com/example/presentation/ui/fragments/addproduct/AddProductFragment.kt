package com.example.presentation.ui.fragments.addproduct

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAddProductBinding
import com.example.presentation.ui.fragments.home.HomeFragment
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddProductFragment :
    BaseFragment<FragmentAddProductBinding, AddProductViewModel>(R.layout.fragment_add_product) {

    override val binding by viewBinding(FragmentAddProductBinding::bind)
    override val viewModel: AddProductViewModel by viewModels()
    private val db = Firebase.firestore

    override fun setupListeners() {
        binding.swoosh.setOnClickListener {
            val message = binding.etProduct.text.toString()
            val kcalNumber = binding.etCcal.text.toString()
            val kcalNumberInt = binding.etCcal.text.toString().trim().toInt()
            val result = viewModel.progressKcal + kcalNumberInt
            if (message.isEmpty()) {
                binding.etProduct.error = "Введите название продукта"
            } else if (kcalNumber.isEmpty()) {
                binding.etCcal.error = "Введите норму ккалорий"
            } else if (message == "/report") {
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            } else {
                viewModel.progressKcal = result
                Log.d("resultA", "progress Add Product = ${viewModel.progressKcal}")
                sendMessage()
            }
        }
    }

    private fun sendMessage() {
        val currentDate = Timestamp.now()
        val formatterUse = SimpleDateFormat("dd.MM.yyyy'г'", Locale.CHINA)
        val time = formatterUse.format(Date())
        val timeText = time.toString()
        val numberKcal = binding.etCcal.text.toString()
        val textTitle = binding.etProduct.text.toString()
        val user = hashMapOf(
            "text" to textTitle, "message" to numberKcal, "time" to timeText, "date" to currentDate
        )
        viewModel.userName?.let { db.collection(it).document().set(user) }
        findNavController().navigateUp()
    }
}