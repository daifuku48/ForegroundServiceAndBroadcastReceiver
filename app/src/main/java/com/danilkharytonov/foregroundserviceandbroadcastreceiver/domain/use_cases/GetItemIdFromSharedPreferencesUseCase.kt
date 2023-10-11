package com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import javax.inject.Inject

class GetItemIdFromSharedPreferencesUseCase @Inject constructor(
    private val repository: ItemsRepository
) {
    fun execute() : Int {
        return repository.getItemIdFromSharedPreferences()
    }
}