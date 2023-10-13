package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentRandomNumberCoroutinesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RandomNumberCoroutineFragment : Fragment() {

    private var _binding: FragmentRandomNumberCoroutinesBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: RandomNumberCoroutinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomNumberCoroutinesBinding.inflate(inflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.number.observe(viewLifecycleOwner) { randomNumber ->
            binding.numberText.text = getString(R.string.number, randomNumber)
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}