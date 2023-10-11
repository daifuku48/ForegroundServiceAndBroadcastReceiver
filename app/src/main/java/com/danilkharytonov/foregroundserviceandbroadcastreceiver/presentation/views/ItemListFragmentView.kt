package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items

interface ItemListFragmentView {
    fun showItemList(items: Items)
}