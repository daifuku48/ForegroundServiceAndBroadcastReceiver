package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_list_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Items
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.SaveItemIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListItemViewModel @Inject constructor(
    private val getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
    private val getListItemUseCase: GetListItemUseCase,
    private val saveItemIdUseCase: SaveItemIdUseCase
) : ViewModel() {

    private val _itemList = MutableStateFlow<List<Item>>(emptyList())
    val itemList = _itemList.asStateFlow()

    init {
        fetchItems()
    }

    private fun fetchItems(){
        val items = getListItemUseCase.execute()
        _itemList.value = items.getList()
    }

    fun saveItemId(id: Int){
        saveItemIdUseCase.execute(id)
    }

    fun getItemIdFromSharedPreferences() : Int {
        return getItemIdFromSharedPreferencesUseCase.execute()
    }
}