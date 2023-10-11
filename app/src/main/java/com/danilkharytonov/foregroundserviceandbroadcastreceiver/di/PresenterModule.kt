package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_view.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_view.SaveItemIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.presenters.ItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.presenters.ItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.presenters.ListItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.presenters.ListItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.views.ItemFragmentView
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.views.ItemListFragmentView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
object PresenterModule {

    @Provides
    fun providesListItemFragmentPresenter(
        getListItemUseCase: GetListItemUseCase,
        saveItemIdUseCase: SaveItemIdUseCase,
        getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
    ) : ListItemFragmentPresenter {
        return ListItemFragmentPresenterImpl(
            getListItemUseCase = getListItemUseCase,
            saveItemIdUseCase = saveItemIdUseCase,
            getItemIdFromSharedPreferencesUseCase = getItemIdFromSharedPreferencesUseCase,
        )
    }

    @Provides
    fun providesItemFragmentPresenter(
        getItemByIdUseCase: GetItemByIdUseCase,
        itemFragmentView: ItemFragmentView
    ) : ItemFragmentPresenter {
        return ItemFragmentPresenterImpl(
            getItemByIdUseCase = getItemByIdUseCase,
        )
    }

}

