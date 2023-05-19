package com.example.presentation.ui.fragments.home

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.models.FirebaseModel
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.ui.adapter.HomeAdapter
import com.example.presentation.ui.fragments.history.HomeFragmentArgs
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home)
    /*OnNoteClickListener*/ {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override lateinit var viewModel: HomeViewModel
    private val homeAdapter = HomeAdapter(/*this*/)
    private val db = Firebase.firestore

    override fun initialize() = with(binding) {
        rvHome.adapter = homeAdapter
        rvHome.layoutManager = StaggeredGridLayoutManager(2, 1)
    }

    override fun setupListeners() {
        setupNavigation()
        setupMessage()
    }

    override fun setupObserves() {
        setupAddText()
    }

    private fun setupAddText() {
        val args: HomeFragmentArgs by navArgs()
        binding.tvNumberCalories.text = args.number.toString()
        Log.d("MyFragment", "Text argument value: ${args.number}")
    }

    private fun setupMessage() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val f = db.collection("home").orderBy("time", Query.Direction.ASCENDING).get()
        f.addOnSuccessListener { data ->
            val message = data.toObjects(FirebaseModel::class.java)
            viewModel.setModels2(message)

            viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                homeAdapter.submitList(it)
            }

            viewModel.loadData()
        }
    }

//    override fun onClickListener(model: FirebaseModel) {
//        val alertDialog = AlertDialog.Builder(requireContext())
//            .setCancelable(true)
//            .setTitle("Удалить заметку")
//            .setMessage("Вы подтверждаете удалить заметку?")
//            .setPositiveButton("да", DialogInterface.OnClickListener() { dialogInterface, i -> dialogInterface
//                db.collection("home").document(id.toString()).delete()
//                    .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
//                    .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
//
//                val docRef = db.collection("home").document(id.toString())
//                val updates = hashMapOf<String, Any>("home" to FieldValue.delete())
//
//                docRef.update(updates).addOnCompleteListener { }
//            })
//
//            .setNegativeButton("нет", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface
//            }).create().show()
//    }

    private fun setupNavigation() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
        btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editDefaultFragment)
        }
        btnHistory.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editDefaultFragment)
        }
    }
}