package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RandomNumberLiveDataViewModel @Inject constructor() : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        generateNumbers()
    }

    private var isRunning = false

    private fun generateNumbers() {
        isRunning = true
        val thread = Thread {
            while (isRunning) {
                val randomNumber = Random.nextInt(1, 100)
                _number.postValue(randomNumber)
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }

    override fun onCleared() {
        super.onCleared()
        isRunning = false
    }
}