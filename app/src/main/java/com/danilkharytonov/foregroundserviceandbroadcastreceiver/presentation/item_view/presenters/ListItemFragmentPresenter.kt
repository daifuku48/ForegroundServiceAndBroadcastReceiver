package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.presenters

interface ListItemFragmentPresenter {
    fun getItemList()
    fun saveId(id: Int)
    fun getItemIdFromSharedPreferences() : Int
}