package com.danilkharytonov.foregroundserviceandbroadcastreceiver.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item


class ItemRecyclerAdapter(
    private val array: Array<Item>) : RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>(){

    var onItemClick : ((Item) -> Unit)? = null


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var name: TextView

        init{
            name = view.findViewById(R.id.item_name)
            itemView.setOnClickListener {
                onItemClick?.invoke(array[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = array[position].name
    }

    override fun getItemCount() = array.size

}