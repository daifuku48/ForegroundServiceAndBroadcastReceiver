package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentRandomNumberLivedataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomNumberLiveDataFragment : Fragment() {
    private var _binding: FragmentRandomNumberLivedataBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: RandomNumberLiveDataViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomNumberLivedataBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.number.observe(viewLifecycleOwner) { number ->
            binding.numberText.text = getString(R.string.number, number)
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}