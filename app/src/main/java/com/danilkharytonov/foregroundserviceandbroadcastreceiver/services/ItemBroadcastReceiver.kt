package com.danilkharytonov.foregroundserviceandbroadcastreceiver.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemViewActivity
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemViewActivity.Companion.UNDEFIEND_VALUE

class ItemBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) {
            Log.e("ItemBroadcastReceiver", "Received broadcast with null context")
            return
        }
        Log.d("notification is clicked", "notification is clicked")
        if (intent?.action == "APP_NOTIFICATION_CLICK") {
            val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
            val id = sharedPreferences.getInt(ITEM_KEY_ID, UNDEFIEND_VALUE)
            if (id == UNDEFIEND_VALUE) {
                context?.startActivity(Intent(context, ItemListActivity::class.java))
            } else {
                context?.startActivity(Intent(context, ItemViewActivity::class.java))
            }
        }
    }
}