package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.views.ItemFragmentView

interface ItemFragmentPresenter {
    fun getItemById(id: Int)
}