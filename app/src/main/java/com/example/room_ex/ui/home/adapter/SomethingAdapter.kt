package com.example.room_ex.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.models.SomethingDB
import com.example.room_ex.databinding.ItemSomethingBinding

class SomethingAdapter: RecyclerView.Adapter<SomethingAdapter.ViewHolder>() {

    var items: List<SomethingDB> = listOf()

    inner class ViewHolder(
        private val binding: ItemSomethingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SomethingDB) {
            binding.apply {
                title.text = model.title
                subtitle.text = model.subtitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSomethingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun set(items: List<SomethingDB>) {
        this.items = listOf()
        this.items = items
        notifyDataSetChanged()
    }
}