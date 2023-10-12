package com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.repository

import android.content.Context
import androidx.core.content.edit
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.SHARED_PREF
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val context: Context
) : ItemsRepository {
    override fun getItemList(): Items {
        return Items
    }

    override fun getItemById(id: Int): Item {
        return Items.getItemById(id)
    }

    override fun saveItemId(id: Int) {
        context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE).edit {
            putInt(ITEM_KEY_ID, id)
        }
    }

    override fun getItemIdFromSharedPreferences(): Int {
        return context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
            .getInt(ITEM_KEY_ID, 0)
    }
}