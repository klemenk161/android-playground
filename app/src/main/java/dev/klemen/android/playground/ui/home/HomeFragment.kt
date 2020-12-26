package dev.klemen.android.playground.ui.home

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.R
import dev.klemen.android.playground.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel>(HomeViewModel::class, R.layout.fragment_home) {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchData()
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic fun newInstance(param1: String? = null, param2: String? = null) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
