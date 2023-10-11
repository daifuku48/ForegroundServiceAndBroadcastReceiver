package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item

interface ItemFragmentPresenter {
    fun getItemById(id: Int)
}