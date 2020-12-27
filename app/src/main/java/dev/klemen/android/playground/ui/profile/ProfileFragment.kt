package dev.klemen.android.playground.ui.profile

import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentProfileBinding
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    ProfileViewModel::class,
    R.layout.fragment_profile
)
