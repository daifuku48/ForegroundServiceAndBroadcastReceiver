package com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items

interface ItemsRepository {
    fun getItemList(): Items

    fun getItemById(id: Int): Item

    fun saveItemId(id: Int)

    fun getItemIdFromSharedPreferences(): Int
}