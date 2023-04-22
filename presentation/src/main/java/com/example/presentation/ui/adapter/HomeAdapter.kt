package com.example.presentation.ui.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemHomeGridBinding
import com.example.presentation.model.FirebaseModel

class HomeAdapter : ListAdapter<FirebaseModel, HomeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemHomeGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: FirebaseModel) {
            binding.tvTitleItemHome.text = model.text
            binding.tvCaloriesItemHome.text = model.message
            binding.tvDateItemHome.text = model.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FirebaseModel>() {
            override fun areItemsTheSame(oldItem: FirebaseModel, newItem: FirebaseModel): Boolean {
                return oldItem.time == newItem.time
            }

            override fun areContentsTheSame(oldItem: FirebaseModel, newItem: FirebaseModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}