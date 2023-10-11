package com.danilkharytonov.foregroundserviceandbroadcastreceiver.di

import androidx.fragment.app.Fragment
import com.danilkharytonov.foregroundserviceandbroadcastreceiver.presentation.fragments.ItemFragment
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



@InstallIn(FragmentComponent::class)
@Module
abstract class ViewModule {

    @Binds
    abstract fun bindItemListFragmentView(fragment: ListItemFragment): ItemListFragmentView

    @Binds
    abstract fun bindItemFragmentView(fragment: ItemFragment) : ItemFragmentView

}

@InstallIn(FragmentComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindListItemFragment(fragment: Fragment): ListItemFragment {
        return fragment as ListItemFragment
    }

    @Provides
    fun bindItemFragment(fragment: Fragment) : ItemFragment {
        return fragment as ItemFragment
    }
}