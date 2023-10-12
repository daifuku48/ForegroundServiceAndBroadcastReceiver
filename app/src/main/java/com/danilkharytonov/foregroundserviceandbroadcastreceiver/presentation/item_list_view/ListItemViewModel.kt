package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_list_view.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_list_view.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_list_view.SaveItemIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListItemViewModel @Inject constructor(
    private val getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
    private val getListItemUseCase: GetListItemUseCase,
    private val saveItemIdUseCase: SaveItemIdUseCase
) : ViewModel() {

    val state: MutableLiveData<ListItemState> = MutableLiveData(ListItemState())

    fun getItemList() {
        state.value?.items = getListItemUseCase.execute().getList()
    }

    fun saveItemId(id: Int) {
        saveItemIdUseCase.execute(id)
    }

    fun getItemIdFromSharedFromSharedPreferences() {
        state.value?.itemIdFromSharedPreferences = getItemIdFromSharedPreferencesUseCase.execute()
    }
}