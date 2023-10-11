package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.views

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item

interface ItemFragmentView {
    fun showItem(item: Item)
}