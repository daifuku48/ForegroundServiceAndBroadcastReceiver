package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.base

import java.lang.ref.WeakReference

abstract class BasePresenter<View> {

    private var _view: WeakReference<View>? = null
    protected val view: View
        get() = _view?.get() ?: throw IllegalStateException()

    fun attach(view: View) {
        _view = WeakReference(view)
    }

    fun detach() {
        _view = null
    }
}