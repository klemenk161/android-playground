package dev.klemen.android.playground.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dev.klemen.android.playground.ui.home.AvailablePageFragment
import dev.klemen.android.playground.ui.home.ProgressPageFragment

@Module
@InstallIn(FragmentComponent::class)
class HomeModule {

    @Provides
    fun provideAdapter(activity: FragmentActivity): FragmentStateAdapter {
        val fragments = listOf(AvailablePageFragment(), ProgressPageFragment())
        return object : FragmentStateAdapter(activity) {
            override fun createFragment(position: Int): Fragment = fragments[position]

            override fun getItemCount(): Int = fragments.size
        }
    }
}
