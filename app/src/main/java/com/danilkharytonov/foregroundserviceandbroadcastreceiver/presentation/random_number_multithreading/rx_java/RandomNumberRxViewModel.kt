package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.rx_java

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RandomNumberRxViewModel @Inject constructor() : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        generateNumbers()
    }

    private fun generateNumberData(): Observable<Int> {
        return Observable.create { subscriber ->
            while (true) {
                subscriber.onNext(Random.nextInt(1, 100))
                Thread.sleep(2000L)
            }
        }
    }

    private fun generateNumbers() {
        val numbers = generateNumberData().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe { number ->
                _number.value = number
            }
    }
}