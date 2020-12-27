package dev.klemen.android.playground.ui.learn

import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentLearnBinding
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class LearnFragment : BaseFragment<LearnViewModel, FragmentLearnBinding>(
    LearnViewModel::class,
    R.layout.fragment_learn
)
