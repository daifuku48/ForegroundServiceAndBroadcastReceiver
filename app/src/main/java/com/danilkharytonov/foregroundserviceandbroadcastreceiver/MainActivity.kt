package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.fragments.ListItemFragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemBroadcastReceiver
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemForegroundService

class MainActivity : AppCompatActivity() {

    companion object {
        const val ITEM_KEY_ID = "ITEM_KEY_ID"
        const val SHARED_PREF = "SHARED_PREF"
        const val UNDEFINED_VALUE = -1
        const val CHANNEL_ID = "CHANNEL_ID"
        const val CHANNEL_NAME = "CHANNEL_NAME"
        const val APP_NOTIFICATION_CLICK = "APP_NOTIFICATION_CLICK"
        const val FRAGMENT_ID = "FRAGMENT_ID"
        const val ITEMS_LIST_FRAGMENT_ID = 0
        const val ITEM_FRAGMENT_ID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startServiceAndBroadcastReceiver()
    }

    private fun startServiceAndBroadcastReceiver() {
        startService(Intent(this, ItemForegroundService::class.java))
        val intentFilter = IntentFilter(APP_NOTIFICATION_CLICK)
        registerReceiver(ItemBroadcastReceiver(), intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, ItemForegroundService::class.java))
    }
}