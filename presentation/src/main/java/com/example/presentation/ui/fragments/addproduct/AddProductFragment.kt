package com.example.presentation.ui.fragments.addproduct

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentAddProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductFragment :
    BaseFragment<FragmentAddProductBinding, AddProductViewModel>(R.layout.fragment_add_product) {

    override val binding by viewBinding(FragmentAddProductBinding::bind)
    override val viewModel: AddProductViewModel by viewModels()
}