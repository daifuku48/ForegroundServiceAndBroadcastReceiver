package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item

interface ItemFragmentView {
    fun showItem(item: Item)
}