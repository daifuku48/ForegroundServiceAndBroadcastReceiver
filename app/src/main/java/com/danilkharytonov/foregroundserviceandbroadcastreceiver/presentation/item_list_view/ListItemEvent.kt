package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items

sealed class ListItemEvent  {
    data object ItemsLoad : ListItemEvent()
    class SaveItemId(var id: Int) : ListItemEvent()
    data object LoadIdFromSharedPreferences : ListItemEvent()
}