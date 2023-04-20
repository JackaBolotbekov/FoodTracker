package com.example.presentation.ui.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.local.dtos.NoteDto
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.ui.adapter.HomeAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()
    private val db = Firebase.firestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMessage()
    }

    override fun initialize() {
        binding.recyclerView.adapter = homeAdapter
    }

    private fun getMessage() {
        db.collection("user").document("new").addSnapshotListener { doc, e ->
            val f = db.collection("user").get()
            f.addOnSuccessListener { data ->
                val message = data.toObjects(NoteDto::class.java)
                viewModel.setModels2(message)
            }

            viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                homeAdapter.submitList(it)
            }
        }
    }

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
    }
}