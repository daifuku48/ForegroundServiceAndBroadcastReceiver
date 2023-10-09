package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ListItemsFragment.Companion.ITEM_KEY_DESCRIPTION
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ListItemsFragment.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ListItemsFragment.Companion.ITEM_KEY_NAME

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ItemViewLayoutBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item

class ItemViewFragment : Fragment() {
    private var _binding : ItemViewLayoutBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ItemViewLayoutBinding.inflate(inflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments
        val itemId = arguments?.getInt(ITEM_KEY_ID)
        val itemName = arguments?.getString(ITEM_KEY_NAME)
        val itemDescription = arguments?.getString(ITEM_KEY_DESCRIPTION)

        binding.itemId.text = "id: $itemId"
        binding.itemName.text = "name: $itemName"
        binding.itemDescription.text = "description: $itemDescription"

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}