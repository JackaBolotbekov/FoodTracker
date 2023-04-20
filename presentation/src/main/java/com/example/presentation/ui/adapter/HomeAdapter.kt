package com.example.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.local.dtos.NoteDto
import com.example.presentation.databinding.ItemHomeBinding

class HomeAdapter : ListAdapter<NoteDto, HomeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: NoteDto) {
            binding.data.text = model.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
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
        val diffUtil = object : DiffUtil.ItemCallback<NoteDto>() {
            override fun areItemsTheSame(oldItem: NoteDto, newItem: NoteDto): Boolean {
                return oldItem.data == newItem.data
            }

            override fun areContentsTheSame(oldItem: NoteDto, newItem: NoteDto): Boolean {
                return oldItem == newItem
            }
        }
    }
}