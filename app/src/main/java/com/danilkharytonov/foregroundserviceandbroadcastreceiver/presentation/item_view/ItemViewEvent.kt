package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view

interface ItemViewEvent {
    class LoadItemByIdEvent(var id: Int) : ItemViewEvent
}