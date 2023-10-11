package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import android.content.Context
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.data.repository.ItemRepositoryImpl
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideItemRepository(@ApplicationContext context: Context) : ItemsRepository{
        return ItemRepositoryImpl(
            context = context
        )
    }
}