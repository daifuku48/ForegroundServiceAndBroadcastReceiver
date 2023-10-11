package com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.model.Item
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemFragmentView
import javax.inject.Inject

class ItemFragmentPresenterImpl @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase,
    private val itemFragmentView: ItemFragmentView
): ItemFragmentPresenter {
    override fun getItemById(id: Int) {
        val item = getItemByIdUseCase.execute(id)
        itemFragmentView.showItem(item)
    }
}