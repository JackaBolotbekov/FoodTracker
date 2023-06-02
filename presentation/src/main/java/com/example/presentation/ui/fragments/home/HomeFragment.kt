package com.example.presentation.ui.fragments.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
//        initial()
        binding.rvHome.adapter = homeAdapter
        getMessage()
        updateProgressBar()
    }

    override fun setupListeners() {
        click()
    }

  /*  private fun initial() = with(binding) {
        val currentTime = Calendar.getInstance().time
        val targetTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, AlarmService.HOUR_OF_DAY)
            set(Calendar.MINUTE, AlarmService.MINUTE)
            set(Calendar.SECOND, 0)
        }.time

        if (currentTime.before(targetTime)) {
            setAlarm(requireContext())
        }
        rvHome.adapter = homeAdapter
        btnGrid.setOnClickListener {
            rvHome.layoutManager = LinearLayoutManager(requireContext())
            rvHome.adapter = homeAdapter
            btnGrid.isGone = true
            btnLinear.isGone = false
        }
        btnLinear.setOnClickListener {
            rvHome.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            rvHome.adapter = homeAdapter
            btnLinear.isGone = true
            btnGrid.isGone = false
        }
    }*/

    private fun getMessage() {
        viewModel.userName?.let { userName ->
            db.collection(userName).document().addSnapshotListener { _, _ ->
                val f = db.collection(userName).orderBy("date", Query.Direction.ASCENDING).get()
                f.addOnSuccessListener { data ->
                    val message = data.toObjects(FirebaseModel::class.java)
                    viewModel.setModels2(message)
                }
                viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                    homeAdapter.submitList(it)
                }
            }

            var sum = 0
            val docRef = db.collection(userName)
            docRef.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        Log.d("resultB", "${document.data.getValue("message")}")
                        sum += document.data.getValue("message").toString().toInt()
                    }
                    Log.d("sum", "$sum")
                    viewModel.progressKcal = sum
                    viewModel.progressKcal.let {
                        Log.d("sumVM", "$it")
                    }
                    binding.progressBar.progress = viewModel.progressKcal
                    Log.d("resultA", "sum = ${binding.progressBar.progress}")
                }
                .addOnFailureListener { exception ->
                    Log.d("resultB", "Error getting documents: ", exception)
                }
        }
    }

    private fun click() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
        btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editDefaultFragment)
        }
        btnHistory.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
    }

    private fun updateProgressBar() = with(binding) {
//        viewModel.progressKcal = 0
        val progress = viewModel.progressKcal
        Log.d("resultA", "progress view model = ${viewModel.progressKcal}")
        progressBar.progress = progress
        Log.d("resultA", "progress bar = ${progressBar.progress}")
        progressBar.max = viewModel.defaultKcalText!!.toInt()
        Log.d("resultA", "max HomeFragment = ${viewModel.defaultKcalText}")
        tvNumberCalories.text = viewModel.defaultKcalText
    }
}