package com.example.presentation.ui.fragments.addproduct

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAddProductBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductFragment :
    BaseFragment<FragmentAddProductBinding, AddProductViewModel>(R.layout.fragment_add_product) {

    override val binding by viewBinding(FragmentAddProductBinding::bind)
    override val viewModel: AddProductViewModel by viewModels()
    private val firebase = Firebase.firestore

    override fun setupSubscribes() {
        binding.btnSave.setOnClickListener {
            val collectionRef = firebase.collection("user")
            val message = hashMapOf(
                "message" to binding.etProduct.text.toString()
            )

            findNavController().navigateUp()
            collectionRef.add(message).addOnSuccessListener {
            }
        }
    }
}
