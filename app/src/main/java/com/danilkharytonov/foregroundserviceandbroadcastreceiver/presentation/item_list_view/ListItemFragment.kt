package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentListItemBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view.adapters.ItemListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListItemFragment : Fragment(){
    private var _binding: FragmentListItemBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: ListItemViewModel by viewModels()

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
        viewModel.getItemList()
        initItemList()
        checkIntentForBroadCastReceiver()
    }

    private fun initItemList() {
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = ItemListAdapter { item ->
            //Save id in sharedPreferences
            viewModel.saveItemId(item.id)
            findNavController().navigate(
                R.id.action_listItemFragment_to_itemFragment, bundleOf(
                    ITEM_KEY_ID to item.id
                )
            )
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.items)
        }

        binding.list.layoutManager = layoutManager
        binding.list.adapter = adapter
    }

    private fun checkIntentForBroadCastReceiver() {
        val intent = activity?.intent
        val fragmentId = intent?.getIntExtra(FRAGMENT_ID, 0)
        if (fragmentId == ITEM_FRAGMENT_ID) {
            viewModel.getItemIdFromSharedFromSharedPreferences()
            findNavController().navigate(
                R.id.action_listItemFragment_to_itemFragment, bundleOf(
                    ITEM_KEY_ID to viewModel.state.value?.itemIdFromSharedPreferences
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}