package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemByIdUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetItemIdFromSharedPreferencesUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.GetListItemUseCase
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.use_cases.SaveItemIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


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
    fun providesSaveItemByIdUseCase(itemsRepository: ItemsRepository) : SaveItemIdUseCase{
        return SaveItemIdUseCase(itemsRepository)
    }
}