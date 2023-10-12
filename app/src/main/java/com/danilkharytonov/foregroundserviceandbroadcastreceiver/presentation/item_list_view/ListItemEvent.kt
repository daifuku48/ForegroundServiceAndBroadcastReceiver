package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

sealed class ListItemEvent  {
    data object ItemsLoad : ListItemEvent()
    class SaveItemId(var id: Int) : ListItemEvent()
    data object LoadIdFromSharedPreferences : ListItemEvent()
}