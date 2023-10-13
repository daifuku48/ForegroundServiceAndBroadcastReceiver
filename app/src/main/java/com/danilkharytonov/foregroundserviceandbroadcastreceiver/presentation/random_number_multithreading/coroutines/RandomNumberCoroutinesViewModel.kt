package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class RandomNumberCoroutinesViewModel @Inject constructor() : ViewModel() {

    private val _number = MutableStateFlow(0)
    val number: StateFlow<Int>
        get() = _number

    init {
        startGenerating()
    }

    private fun startGenerating() {
        viewModelScope.launch {
            while (true) {
                val number = Random.nextInt(1, 100)
                _number.value = number
                delay(2000L)
            }
        }
    }
}