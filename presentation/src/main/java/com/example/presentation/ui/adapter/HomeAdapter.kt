package com.example.presentation.ui.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.FirebaseModel
import com.example.presentation.databinding.ItemHomeGridBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter(
//    private val onNoteClick: OnNoteClickListener,
//    private val onClickListener: (id: String) -> Unit
) :
    ListAdapter<FirebaseModel, HomeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemHomeGridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: FirebaseModel/*, listener: OnNoteClickListener*/) {
            val formatter = SimpleDateFormat("dd.MM.yyyy'г'", Locale.CHINA)
            val time = formatter.format(Date())
            val timeText = time.toString()
            binding.tvTitleItemHome.text = model.text
            binding.tvCaloriesItemHome.text = model.message
            binding.tvDateItemHome.text = timeText


//            itemView.setOnLongClickListener {
//                listener.onClickListener(model)
//                return@setOnLongClickListener true
//            }
        }

//        }

//        init {
//            itemView.setOnClickListener {
//                getItem(bindingAdapterPosition).apply { onClickListener(id.toString()) }
//            }
//        }
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
            holder.onBind(it/*, onNoteClick*/)
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

//interface OnNoteClickListener {
//    fun onClickListener(model: FirebaseModel)
//}