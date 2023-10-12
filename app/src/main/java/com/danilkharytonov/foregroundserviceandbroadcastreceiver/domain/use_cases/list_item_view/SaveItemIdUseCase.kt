package com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import javax.inject.Inject

class SaveItemIdUseCase @Inject constructor(
    private val repository: ItemsRepository
) {
    fun execute(id: Int){
        repository.saveItemId(id)
    }
}