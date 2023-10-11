package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.ITEM_FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.adapters.ItemListAdapter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentListItemBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ListItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemListFragmentView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ListItemFragment : Fragment(), ItemListFragmentView {

    private var _binding: FragmentListItemBinding? = null
    private val binding
        get() = _binding!!
    @Inject lateinit var presenter: ListItemFragmentPresenterImpl

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
        binding.list.layoutManager = layoutManager
        presenter.getItemList()
    }

    private fun checkIntentForBroadCastReceiver(){
        val intent = activity?.intent
        val fragmentId = intent?.getIntExtra(FRAGMENT_ID, 0)
        if (fragmentId == ITEM_FRAGMENT_ID){
            findNavController().navigate(R.id.action_listItemFragment_to_itemFragment, bundleOf(
                ITEM_KEY_ID to presenter.getItemIdFromSharedPreferences()
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showItemList(items: Items) {
        val adapter = ItemListAdapter{ item ->
            presenter.saveId(item.id)
            findNavController().navigate(R.id.action_listItemFragment_to_itemFragment, bundleOf(
                ITEM_KEY_ID to item.id
            ))
        }
        adapter.submitList(items.getList())
        binding.list.adapter = adapter
    }

}