package com.example.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.FirebaseModel
import com.example.presentation.databinding.ItemHistoryBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryAdapter:
    ListAdapter<FirebaseModel, HistoryAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: FirebaseModel) {
            val formatter = SimpleDateFormat("dd.MM.yyyy'г'", Locale.CHINA)
            val time = formatter.format(Date())
            val timeText = time.toString()
            binding.tvCaloriesItemHistory.text = model.message
            binding.tvDateItemHistory.text = timeText
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
        val diffUtil = object : DiffUtil.ItemCallback<FirebaseModel>() {
            override fun areItemsTheSame(
                oldItem: FirebaseModel,
                newItem: FirebaseModel
            ): Boolean {
                return oldItem.time == newItem.time
            }

            override fun areContentsTheSame(
                oldItem: FirebaseModel,
                newItem: FirebaseModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}