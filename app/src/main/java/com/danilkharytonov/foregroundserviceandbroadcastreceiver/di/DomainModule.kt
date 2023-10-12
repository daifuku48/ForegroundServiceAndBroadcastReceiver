package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.item_view.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.list_item_view.SaveItemIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providesGetListItemUseCase(itemsRepository: ItemsRepository) : GetListItemUseCase {
        return GetListItemUseCase(itemsRepository)
    }

    @Provides
    fun providesGetItemByIdUseCase(itemsRepository: ItemsRepository) : GetItemByIdUseCase {
        return GetItemByIdUseCase(itemsRepository)
    }

    @Provides
    fun providesGetItemIdFromSharedPreferencesUseCase(
        itemsRepository: ItemsRepository
    ) : GetItemIdFromSharedPreferencesUseCase {
        return GetItemIdFromSharedPreferencesUseCase(itemsRepository)
    }

    @Provides
    fun providesSaveItemByIdUseCase(itemsRepository: ItemsRepository) : SaveItemIdUseCase {
        return SaveItemIdUseCase(itemsRepository)
    }
}