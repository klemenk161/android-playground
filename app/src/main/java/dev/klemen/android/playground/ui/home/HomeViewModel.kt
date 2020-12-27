package dev.klemen.android.playground.ui.home

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import dev.klemen.android.playground.ui.base.BaseViewModel

class HomeViewModel @ViewModelInject constructor(
    application: Application,
) : BaseViewModel(application)
