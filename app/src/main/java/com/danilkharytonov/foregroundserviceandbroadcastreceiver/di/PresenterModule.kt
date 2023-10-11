package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.fragments.ListItemFragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.presenters.ListItemFragmentPresenterImpl
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
        itemListFragmentView: ItemListFragmentView
    ) : ListItemFragmentPresenterImpl {
        return ListItemFragmentPresenterImpl(
            getListItemUseCase = getListItemUseCase,
            itemListFragmentView =  itemListFragmentView
        )
    }
}

