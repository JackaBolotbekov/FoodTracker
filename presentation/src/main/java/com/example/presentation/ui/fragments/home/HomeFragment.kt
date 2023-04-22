package com.example.presentation.ui.fragments.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.model.FirebaseModel
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
    var progress = 0

    override fun initialize() {
        initial()
        getMessage()
        click()
    }

    private fun initial() = with(binding) {
        tvNumberCalories.setText(R.string.number_0)
        rvHome.adapter = homeAdapter
        rvHome.layoutManager = StaggeredGridLayoutManager(2, 1)
    }

    private fun getMessage() {
        db.collection("home").document().addSnapshotListener { doc, e ->
            val f = db.collection("home").get()
            f.addOnSuccessListener { data ->
                val message = data.toObjects(FirebaseModel::class.java)
                viewModel.setModels2(message)
            }

            viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                homeAdapter.submitList(it)
            }
        }
    }

    private fun click() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
        btnEdit.setOnClickListener {
            if (progress >= 10) {
                progress -= 10
                updateProgressBar()
            }
        }
        btnHistory.setOnClickListener {
            if (progress <= 90) {
                progress += 10
                updateProgressBar()
            }
        }
    }

    fun updateProgressBar() = with(binding) {
        progressBar.progress = progress
        tvNumberCalories.text = progress.toString()
    }
}