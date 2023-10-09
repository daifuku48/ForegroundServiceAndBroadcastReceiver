package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemBroadcastReceiver
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemForegroundService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService(Intent(this, ItemForegroundService::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, ItemForegroundService::class.java))
    }
}