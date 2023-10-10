package com.danilkharytonov.foregroundserviceandbroadcastreceiver.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ItemListBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item


class ItemListAdapter(private val listener: Listener) :
    ListAdapter<Item, ItemListAdapter.ViewHolder>(ItemCallback),
    View.OnClickListener {

    override fun onClick(v: View) {
        val item = v.tag as Item
        when (v.id) {
            else -> listener.onClickItem(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.itemName.text = item.name

        holder.itemView.tag = item
    }

    class ViewHolder(
        val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root)

    object ItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    interface Listener {
        fun onClickItem(item: Item)
    }
}