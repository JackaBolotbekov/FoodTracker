package com.example.presentation.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemHistoryBinding
import com.example.presentation.model.FirebaseHistoryModel

class HistoryAdapter : ListAdapter<FirebaseHistoryModel, HistoryAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(model: FirebaseHistoryModel) {
            binding.tvCaloriesItemHistory.text = model.calories + " ккалорий"
            model.calories?.let { Log.d("model", it) }
            binding.tvDateItemHistory.text = model.time
            model.time?.let { Log.d("model", it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(
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
        val diffUtil = object : DiffUtil.ItemCallback<FirebaseHistoryModel>() {
            override fun areItemsTheSame(
                oldItem: FirebaseHistoryModel,
                newItem: FirebaseHistoryModel
            ): Boolean {
                return oldItem.time == newItem.time
            }

            override fun areContentsTheSame(
                oldItem: FirebaseHistoryModel,
                newItem: FirebaseHistoryModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}