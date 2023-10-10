package com.danilkharytonov.foregroundserviceandbroadcastreceiver.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.ITEM_FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.adapters.ItemListAdapter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentListItemBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Items

class ListItemFragment: Fragment() {
    private var _binding: FragmentListItemBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListItemBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initItemList()
        checkIntentForBroadCastReceiver()

    }

    private fun initItemList(){
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = ItemListAdapter(object : ItemListAdapter.Listener {
            override fun onClickItem(item: Item) {
                val sharedPreferences = requireContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
                sharedPreferences.edit {
                    putInt(ITEM_KEY_ID, item.id)
                }
                findNavController().navigate(R.id.action_listItemFragment_to_itemFragment)
            }
        })
        adapter.submitList(Items.getList())
        binding.list.layoutManager = layoutManager
        binding.list.adapter = adapter
    }

    private fun checkIntentForBroadCastReceiver(){
        val intent = activity?.intent
        val fragmentId = intent?.getIntExtra(FRAGMENT_ID, 0)
        if (fragmentId == ITEM_FRAGMENT_ID){
            findNavController().navigate(R.id.action_listItemFragment_to_itemFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}