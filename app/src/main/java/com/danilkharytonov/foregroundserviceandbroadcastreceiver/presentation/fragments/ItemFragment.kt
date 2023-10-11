package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentItemBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemFragmentView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ItemFragment : Fragment(), ItemFragmentView{
    @Inject lateinit var presenter: ItemFragmentPresenter
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
            findNavController().popBackStack()
        }
        val id = arguments?.getInt(ITEM_KEY_ID)
        if (id != null){
            presenter.getItemById(id)
        }
    }

    override fun showItem(item: Item) {
        binding.itemId.text = getString(R.string.id, item.id)
        binding.itemName.text = getString(R.string.name, item.name)
        binding.itemDescription.text = getString(R.string.description, item.description)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}