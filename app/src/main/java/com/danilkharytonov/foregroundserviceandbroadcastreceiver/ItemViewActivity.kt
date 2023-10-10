package com.danilkharytonov.foregroundserviceandbroadcastreceiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.ITEM_KEY_DESCRIPTION
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.ITEM_KEY_ID
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.ITEM_KEY_NAME
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.ItemListActivity.Companion.SHARED_PREF
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.databinding.ActivityItemViewBinding
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.services.ItemBroadcastReceiver

class ItemViewActivity : AppCompatActivity() {

    private var _binding: ActivityItemViewBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityItemViewBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        val sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val id = sharedPreferences.getInt(ITEM_KEY_ID, UNDEFIEND_VALUE)
        val itemName = sharedPreferences.getString(ITEM_KEY_NAME, "Item 0")
        val itemDescription = sharedPreferences.getString(ITEM_KEY_DESCRIPTION, "Description of item 0")
        binding.itemId.text = "id: $id"
        binding.itemName.text = "name: $itemName"
        binding.itemDescription.text = "description: $itemDescription"

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, ItemListActivity::class.java))
        }
        val filter = IntentFilter("APP_NOTIFICATION_CLICK")
        registerReceiver(ItemBroadcastReceiver(), filter)
    }


    companion object {
        const val UNDEFIEND_VALUE = -1
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}