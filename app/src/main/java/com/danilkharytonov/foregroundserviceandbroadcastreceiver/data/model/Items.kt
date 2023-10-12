package com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model

object Items {
    private val list = List(20) { id ->
        Item(id, "item $id", "description of item $id")
    }

    fun getItemById(id: Int): Item {
        return list[id]
    }

    fun getList(): List<Item> {
        return list
    }
}