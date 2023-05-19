package com.example.presentation.ui.fragments.delete

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.FirebaseModel
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentDeleteBinding
import com.example.presentation.ui.fragments.addproduct.AddProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class DeleteFragment :
    BaseFragment<FragmentDeleteBinding, AddProductViewModel>(R.layout.fragment_delete) {

    override val binding by viewBinding(FragmentDeleteBinding::bind)
    override val viewModel: AddProductViewModel by viewModels()
//    private val args by navArgs<DeleteFragmentArgs>()
//    private val model= FirebaseModel()
//
//    override fun initialize() {
//        setupListener()
//    }
//
//    private fun setupListener() {
//    }
}