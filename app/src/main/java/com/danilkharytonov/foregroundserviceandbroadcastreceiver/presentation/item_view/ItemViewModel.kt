package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_view.GetItemByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase
): ViewModel() {

    val state: MutableLiveData<ItemViewState> = MutableLiveData(ItemViewState())

    fun sendEvent(event: ItemViewEvent){
        when(event){
            is ItemViewEvent.LoadItemByIdEvent -> {
                loadItem(event.id)
            }
        }
    }

    private fun loadItem(id: Int){
        state.value?.item = getItemByIdUseCase.execute(id)
    }
}