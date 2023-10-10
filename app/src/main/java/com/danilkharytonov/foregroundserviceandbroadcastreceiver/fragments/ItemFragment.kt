package com.danilkharytonov.foregroundserviceandbroadcastreceiver.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.MainActivity.Companion.UNDEFINED_VALUE
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentItemBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Items

class ItemFragment : Fragment() {

    private var _binding: FragmentItemBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            Log.d("back", "back")
            findNavController().navigate(R.id.action_itemFragment_to_listItemFragment)
        }

        val sharedPreferences = requireContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val id = sharedPreferences.getInt(ITEM_KEY_ID, UNDEFINED_VALUE)
        val item = Items.getItemById(id)
        binding.itemId.text = getString(R.string.id, item.id)
        binding.itemName.text = getString(R.string.name, item.name)
        binding.itemDescription.text = getString(R.string.description, item.description)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}