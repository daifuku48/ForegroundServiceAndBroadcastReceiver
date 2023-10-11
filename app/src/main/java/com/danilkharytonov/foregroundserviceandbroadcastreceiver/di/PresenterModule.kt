package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.SaveItemIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.fragments.ListItemFragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ListItemFragmentPresenter
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ListItemFragmentPresenterImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemFragmentView
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.views.ItemListFragmentView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(FragmentComponent::class)
object PresenterModule {

    @Provides
    fun providesListItemFragmentPresenter(
        getListItemUseCase: GetListItemUseCase,
        saveItemIdUseCase: SaveItemIdUseCase,
        getItemIdFromSharedPreferencesUseCase: GetItemIdFromSharedPreferencesUseCase,
        itemListFragmentView: ItemListFragmentView
    ) : ListItemFragmentPresenter {
        return ListItemFragmentPresenterImpl(
            getListItemUseCase = getListItemUseCase,
            saveItemIdUseCase = saveItemIdUseCase,
            getItemIdFromSharedPreferencesUseCase = getItemIdFromSharedPreferencesUseCase,
            itemListFragmentView =  itemListFragmentView
        )
    }

    @Provides
    fun providesItemFragmentPresenter(
        getItemByIdUseCase: GetItemByIdUseCase,
        itemFragmentView: ItemFragmentView
    ) : ItemFragmentPresenter {
        return ItemFragmentPresenterImpl(
            getItemByIdUseCase = getItemByIdUseCase,
            itemFragmentView = itemFragmentView
        )
    }

}

