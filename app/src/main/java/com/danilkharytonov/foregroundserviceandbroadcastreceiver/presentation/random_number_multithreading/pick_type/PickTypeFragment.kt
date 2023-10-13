package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.pick_type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentPickTypeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PickTypeFragment : Fragment() {
    private var _binding: FragmentPickTypeBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPickTypeBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rxButton.setOnClickListener {
            findNavController().navigate(R.id.action_pickTypeFragment_to_randomNumberRxFragment)
        }

        binding.coroutineButton.setOnClickListener {
            findNavController().navigate(R.id.action_pickTypeFragment_to_randomNumberCoroutineFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}