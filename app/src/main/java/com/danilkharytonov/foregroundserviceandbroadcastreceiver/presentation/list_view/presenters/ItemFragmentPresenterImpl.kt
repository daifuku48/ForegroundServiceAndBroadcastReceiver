package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_view.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.base.BasePresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.views.ItemFragmentView
import javax.inject.Inject

class ItemFragmentPresenterImpl @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase,
) : BasePresenter<ItemFragmentView>(), ItemFragmentPresenter {

    override fun getItemById(id: Int) {
        val item = getItemByIdUseCase.execute(id)
        view.showItem(item)
    }
}