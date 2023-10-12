package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ItemListBinding


class ItemListAdapter(private val binder: (Item) -> Unit) :
    ListAdapter<Item, ItemListAdapter.ViewHolder>(ItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, binder)
    }

    class ViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Item, onClick:(Item) -> Unit){
            binding.itemName.text = item.name
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    object ItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}