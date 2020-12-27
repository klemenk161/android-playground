package dev.klemen.android.playground.ui.home

import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentProgressPageBinding
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class ProgressPageFragment
    : BaseFragment<ProgressPageViewModel, FragmentProgressPageBinding>(
    ProgressPageViewModel::class,
    R.layout.fragment_progress_page
)
