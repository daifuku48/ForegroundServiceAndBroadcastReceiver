package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.random_number_multithreading.rx_java

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RandomNumberRxViewModel @Inject constructor() : ViewModel() {

    private var _number = BehaviorSubject.create<Int>()
    val number: Observable<Int>
        get() = _number

    private val compositeDisposable = CompositeDisposable()

    init {
        generateNumbers()
    }

    private fun generateNumberData(): Observable<Int> {
        return Observable.interval(2, TimeUnit.SECONDS).map {
            Random.nextInt(1, 100)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun generateNumbers() {
        val disposable = generateNumberData().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe { number ->
                _number.onNext(number)
            }
        compositeDisposable.add(disposable)
    }
}