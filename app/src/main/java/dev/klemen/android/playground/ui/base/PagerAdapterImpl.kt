package dev.klemen.android.playground.ui.base

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterImpl(
    fragment: Fragment,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int = fragments.size
}
