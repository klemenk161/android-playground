package dev.klemen.android.playground.ui.home

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.FragmentAvailablePageBinding
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class AvailablePageFragment
    : BaseFragment<AvailablePageViewModel, FragmentAvailablePageBinding>(
    AvailablePageViewModel::class,
    R.layout.fragment_available_page
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchData()
    }
}
