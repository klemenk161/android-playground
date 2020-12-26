package dev.klemen.android.playground.ui.home

import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentHomeBinding
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    HomeViewModel::class,
    R.layout.fragment_home
)
