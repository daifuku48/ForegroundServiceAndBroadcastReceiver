package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item

data class ListItemState(
    var itemIdFromSharedPreferences: Int = -1,
    var items: List<Item> = emptyList()
)