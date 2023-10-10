package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.adapters.ItemRecyclerAdapter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ActivityMainBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemBroadcastReceiver
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemForegroundService

class ItemListActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        val array = Array(20) {
                id -> Item(id, "item $id", "description of item $id")
        }
        val filter = IntentFilter("APP_NOTIFICATION_CLICK")
        registerReceiver(ItemBroadcastReceiver(), filter)
        val layoutManager = LinearLayoutManager(this)
        val adapter = ItemRecyclerAdapter(array)

        adapter.onItemClick = {
                item ->
            val intent = Intent(this, ItemViewActivity::class.java)
            val sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt(ITEM_KEY_ID, item.id)
            editor.putString(ITEM_KEY_NAME, item.name)
            editor.putString(ITEM_KEY_DESCRIPTION, item.description)
            editor.apply()
            startActivity(intent)
        }

        binding.recyclerList.layoutManager = layoutManager
        binding.recyclerList.adapter = adapter
        startService(Intent(this, ItemForegroundService::class.java))
    }

    companion object {
        const val ITEM_KEY_ID = "ITEM_KEY_ID"
        const val ITEM_KEY_NAME = "ITEM_KEY_NAME"
        const val ITEM_KEY_DESCRIPTION = "ITEM_KEY_DESCRIPTION"
        const val SHARED_PREF = "SHARED_PREF"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        stopService(Intent(this, ItemForegroundService::class.java))
    }
}