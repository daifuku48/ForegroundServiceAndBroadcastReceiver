package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import androidx.fragment.app.Fragment
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
object ViewModule {

    @Provides
    fun providesItemListFragmentView(fragment: Fragment) : ItemListFragmentView {
        return fragment as ItemListFragmentView
    }
}


