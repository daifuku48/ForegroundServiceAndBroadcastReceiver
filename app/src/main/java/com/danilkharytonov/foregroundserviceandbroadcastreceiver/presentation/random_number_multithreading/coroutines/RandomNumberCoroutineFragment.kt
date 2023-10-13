package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.R
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.FragmentRandomNumberCoroutinesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RandomNumberCoroutineFragment : Fragment() {

    private var _binding: FragmentRandomNumberCoroutinesBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: RandomNumberCoroutinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomNumberCoroutinesBinding.inflate(inflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNumber()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initNumber() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.number.collect { randomNumber ->
                    binding.numberText.text = getString(R.string.number, randomNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}