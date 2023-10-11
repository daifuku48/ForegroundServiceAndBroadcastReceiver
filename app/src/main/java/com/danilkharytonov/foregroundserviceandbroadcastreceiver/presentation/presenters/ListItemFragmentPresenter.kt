package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters

interface ListItemFragmentPresenter {
    fun getItemList()
    fun saveId(id: Int)
}