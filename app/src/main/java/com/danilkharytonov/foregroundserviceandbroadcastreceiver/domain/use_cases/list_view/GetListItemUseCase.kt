package com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import javax.inject.Inject

class GetListItemUseCase @Inject constructor(
    private val repository: ItemsRepository
) {
    fun execute() : Items {
        return repository.getItemList()
    }
}