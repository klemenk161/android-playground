package dev.klemen.android.playground.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import dev.klemen.android.playground.databinding.FragmentHomeBinding
import kotlin.reflect.KClass

/**
 * Base class for every Fragment that requires DataBinding.
 * Reduces ViewModel and DataBinding instantiation boiler-plate in actual Fragments.
 *
 * @param viewModelKClass ViewModel class, required for lazily creating the ViewModel.
 * @param layoutId Fragment's LayoutRes id to inflate the layout and create the DataBinding.
 */
abstract class BaseFragment<VM : ViewModel, T: ViewDataBinding>(
    viewModelKClass: KClass<VM>,
    @LayoutRes private val layoutId: Int
) : Fragment() {

    protected lateinit var binding: T
    protected val viewModel by createViewModelLazy(viewModelKClass, { viewModelStore })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*
            1. Create the binding using the DataBindingUtil.
            2. Attach the Fragment as the lifecycleOwner.
            3. Set generic viewModel variable, which every BaseFragment dataBinding will contain.
        */
        binding = DataBindingUtil.inflate<T>(inflater, layoutId, container, false)
            .apply {
                lifecycleOwner = this@BaseFragment
                setVariable(BR.viewModel, viewModel)
            }
        return binding.root
    }
}
