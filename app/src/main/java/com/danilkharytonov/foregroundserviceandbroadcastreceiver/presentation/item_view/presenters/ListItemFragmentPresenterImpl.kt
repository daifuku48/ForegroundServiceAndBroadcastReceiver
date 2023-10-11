package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.SaveItemIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.base.BasePresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.views.ItemListFragmentView
import javax.inject.Inject

class ListItemFragmentPresenterImpl @Inject constructor(
    private val getListItemUseCase: GetListItemUseCase,
    private val saveItemIdUseCase: SaveItemIdUseCase,
    private val getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
) : ListItemFragmentPresenter, BasePresenter<ItemListFragmentView>() {

    override fun getItemList() {
        val items = getListItemUseCase.execute()
        view.showItemList(items)
    }

    override fun saveId(id: Int) {
        saveItemIdUseCase.execute(id)
    }

    override fun getItemIdFromSharedPreferences(): Int {
        return getItemIdFromSharedPreferencesUseCase.execute()
    }
}