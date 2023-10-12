package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item


//data class ListItemState(
 //   var items: List<Item> = emptyList(),
 //   var idFromSharedPreferences: Int = -1
//)

data class ListItemState(
    var itemIdFromSharedPreferences: Int = -1,
    var items: List<Item> = emptyList()
)