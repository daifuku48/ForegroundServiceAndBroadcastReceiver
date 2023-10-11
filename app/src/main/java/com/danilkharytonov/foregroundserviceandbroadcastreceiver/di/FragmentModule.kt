package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import androidx.fragment.app.Fragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.list_view.views.ItemFragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.item_view.views.ListItemFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@InstallIn(FragmentComponent::class)
@Module
object FragmentModule {

    @Provides
    fun bindListItemFragment(fragment: Fragment): ListItemFragment {
        return fragment as ListItemFragment
    }

    @Provides
    fun bindItemFragment(fragment: Fragment) : ItemFragment {
        return fragment as ItemFragment
    }
}