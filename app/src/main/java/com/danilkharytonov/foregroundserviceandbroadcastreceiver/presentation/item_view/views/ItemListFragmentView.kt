package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.views

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items

interface ItemListFragmentView {
    fun showItemList(items: Items)
}