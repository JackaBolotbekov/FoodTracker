package com.example.presentation.ui.fragments.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.local.dtos.NoteDto
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.ui.adapter.HomeAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()
    private val firebase = Firebase.firestore
    private val listAll: MutableList<NoteDto> = ArrayList()

    override fun initialize() {
        binding.recyclerView.adapter = homeAdapter
        firebase.collection("user").addSnapshotListener { value, _ ->
            value?.forEach { data ->
                listAll.add(data.toObject(NoteDto::class.java))
              val message = data.toObject(NoteDto::class.java)
                message.data
            }
            homeAdapter.submitList(listAll)
        }
    }

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
    }
}
