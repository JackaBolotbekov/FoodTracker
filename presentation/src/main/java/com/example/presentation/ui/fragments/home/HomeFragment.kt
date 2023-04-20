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
import kotlin.collections.ArrayList

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()
    private val db = Firebase.firestore
    private val listAll: MutableList<NoteDto> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMessage()
    }

    override fun initialize() {
        binding.recyclerView.adapter = homeAdapter
//        val collection = db.collection("Jaka")
//        collection.addSnapshotListener { value, _ ->
//            if (value != null) {
//                val list = ArrayList<String>()
//                for (string in value) {
//                    string.getString("message")?.let {
//                        list.add(it).toString().trim() // trim() чтобы не отправлять пустату
//                    }
//                }
//        db.collection("user").addSnapshotListener() { doc, e ->
//            doc?.documents?.forEach { it ->
//                it.toObject(NoteDto::class.java).let {
//                    viewModel.setModels(it?.message.toString(), it?.time.toString())
//
//                    db.collection("user").addSnapshotListener { value, _ ->
//                        value?.forEach { data ->
//                            listAll.add(data.toObject(NoteDto::class.java))
//                            data.toObject(NoteDto::class.java).let {
//                                viewModel.setModels(it.message.toString(), it.time.toString())
//                            }
//                            homeAdapter.submitList(listAll)
//                        }
//                    }
//                }
//            }
//        }
    }

    private fun getMessage() {
        db.collection("user").document().addSnapshotListener { doc, e ->

            val f = db.collection("user").get()
            f.addOnSuccessListener { data ->
                val message = data.toObjects(NoteDto::class.java)
                viewModel.setModels2(message)
            }
//            doc?.toObject(NoteDto::class.java).let {
//                viewModel.setModels(it?.message.toString(), it?.time.toString())
//            }
            viewModel.noteLiveData2.observe(viewLifecycleOwner) {
                homeAdapter.submitList(it)
            }
        }
    }
//        firebase.collection("user").addSnapshotListener { value, _ ->
//            value?.forEach { data ->
//                listAll.add(data.toObject(NoteDto::class.java))
//                val message = data.toObject(NoteDto::class.java)
//                message.data
//            }
//            homeAdapter.submitList(listAll)
//        }
//    }

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addProductFragment)
        }
    }
}