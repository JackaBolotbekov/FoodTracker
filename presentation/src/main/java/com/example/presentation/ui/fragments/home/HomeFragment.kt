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
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()
    private val db = Firebase.firestore

    override fun initialize() {
        initial()
        getMessage()
        updateProgressBar()
    }

    override fun setupListeners() {
        click()
    }

    private fun initial() = with(binding) {
        rvHome.adapter = homeAdapter
        rvHome.layoutManager = StaggeredGridLayoutManager(2, 1)
    }

    private fun getMessage() {
        viewModel.userName?.let { userName ->
            db.collection(userName).document().addSnapshotListener { _, _ ->
                val f = db.collection(userName).orderBy("time", Query.Direction.ASCENDING).get()
                f.addOnSuccessListener { data ->
                    val message = data.toObjects(FirebaseModel::class.java)
                    viewModel.setModels2(message)
                }
                viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                    homeAdapter.submitList(it)
                }
            }
        }
    }

    private fun click() = with(binding) {
        val max = viewModel.defaultKcalText!!.toInt()
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
        btnEdit.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_editDefaultFragment)
            progress = viewModel.progressKcal
            if (progress >= 10) {
                progress -= 10
                viewModel.progressKcal = progress
                updateProgressBar()
            }
        }
        btnHistory.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
            progress = viewModel.progressKcal
            if (progress < max) {
                progress += 10
                viewModel.progressKcal = progress
                updateProgressBar()
            }
        }
    }

    fun updateProgressBar() = with(binding) {
        progressBar.progress = viewModel.progressKcal
        progressBar.max = viewModel.defaultKcalText!!.toInt()
        tvNumberCalories.text = viewModel.defaultKcalText
    }

    companion object {
        var progress = 0
    }
}