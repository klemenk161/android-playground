package dev.klemen.android.playground.ui.home

import android.os.Bundle
import android.view.View
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentHomeBinding
import dev.klemen.android.playground.extensions.setup
import dev.klemen.android.playground.ui.base.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(
        HomeViewModel::class,
        R.layout.fragment_home
    ) {

    @Inject
    lateinit var basePagerAdapter: FragmentStateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupTabs()
    }

    private fun setupViewPager() {
        binding.homeViewPager.setup {
            adapter = basePagerAdapter
        }
    }

    private fun setupTabs() {
        TabLayoutMediator(binding.homeTabs, binding.homeViewPager) { tab, position ->
            tab.setup {
                val tabData = when(position) {
                    0 -> R.string.home_tab_available to R.drawable.ic_ok
                    1 -> R.string.home_tab_progress to R.drawable.ic_progress
                    else -> throw NoSuchElementException("No tab at position: $position.")
                }
                setText(tabData.first)
                setIcon(tabData.second)
            }
        }.attach()
    }
}
