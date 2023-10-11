package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.SaveItemIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemListFragmentView
import javax.inject.Inject

class ListItemFragmentPresenterImpl @Inject constructor(
    private val getListItemUseCase: GetListItemUseCase,
    private val saveItemIdUseCase: SaveItemIdUseCase,
    private val getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
    private val itemListFragmentView: ItemListFragmentView
) : ListItemFragmentPresenter {
    override fun getItemList() {
        val items = getListItemUseCase.execute()
        itemListFragmentView.showItemList(items)
    }

    override fun saveId(id: Int) {
        saveItemIdUseCase.execute(id)
    }

    override fun getItemIdFromSharedPreferences(): Int {
        return getItemIdFromSharedPreferencesUseCase.execute()
    }
}