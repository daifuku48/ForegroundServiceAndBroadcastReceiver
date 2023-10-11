package com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(
    private val repository: ItemsRepository
) {
    fun execute(id: Int) : Item {
        return repository.getItemById(id)
    }
}