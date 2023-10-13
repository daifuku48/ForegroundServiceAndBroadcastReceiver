package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class RandomNumberCoroutinesViewModel @Inject constructor() : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
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