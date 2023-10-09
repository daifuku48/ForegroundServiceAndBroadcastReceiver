package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.adapters.ItemRecyclerAdapter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ListItemFragmentBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemBroadcastReceiver
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemForegroundService

class ListItemsFragment : Fragment() {
    private var _binding : ListItemFragmentBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListItemFragmentBinding.inflate(inflater)
        requireContext().startService(Intent(requireContext(), ItemForegroundService::class.java))
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val array = Array(20) {
                id -> Item(id, "item $id", "description of item $id")
        }

        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = ItemRecyclerAdapter(array)
        adapter.onItemClick = {
            item ->
            findNavController().navigate(R.id.action_listItemsFragment_to_itemViewFragment,
                bundleOf(
                    ITEM_KEY_ID to item.id,
                    ITEM_KEY_NAME to item.name,
                    ITEM_KEY_DESCRIPTION to item.description
                ))
            val sharedPreferences = requireContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt(ITEM_KEY_ID, item.id)
            editor.putString(ITEM_KEY_NAME, item.name)
            editor.putString(ITEM_KEY_DESCRIPTION, item.description)
            editor.apply()
        }
        binding.recyclerList.layoutManager = layoutManager
        binding.recyclerList.adapter = adapter
    }

    companion object {
        const val ITEM_KEY_ID = "ITEM_KEY_ID"
        const val ITEM_KEY_NAME = "ITEM_KEY_NAME"
        const val ITEM_KEY_DESCRIPTION = "ITEM_KEY_DESCRIPTION"
        const val SHARED_PREF = "SHARED_PREF"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}