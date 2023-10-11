package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.APP_NOTIFICATION_CLICK
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEMS_LIST_FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_FRAGMENT_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.activity.MainActivity.Companion.UNDEFINED_VALUE

class ItemBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) {
            return
        }

        if (intent?.action == APP_NOTIFICATION_CLICK) {
            val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
            val id = sharedPreferences.getInt(ITEM_KEY_ID, UNDEFINED_VALUE)
            if (id == UNDEFINED_VALUE) {
                context.startActivity(Intent(context, MainActivity::class.java).apply {
                    putExtra(FRAGMENT_ID, ITEMS_LIST_FRAGMENT_ID)
                })
            } else {
                context.startActivity(Intent(context, MainActivity::class.java).apply {
                    putExtra(FRAGMENT_ID, ITEM_FRAGMENT_ID)
                })
            }
        }
    }

}