package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view

import androidx.lifecycle.ViewModel
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_view.GetItemByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase
) : ViewModel() {
    private val _item = MutableStateFlow<Item>(Item(0, "", ""))
    val item = _item.asStateFlow()

    fun getItemById(id: Int) {
        val obj = getItemByIdUseCase.execute(id)
        _item.value = obj
    }
}