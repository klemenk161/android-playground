package dev.klemen.android.playground.ui.profile

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import dev.klemen.android.playground.ui.base.BaseViewModel

class ProfileViewModel @ViewModelInject constructor(
    application: Application
) : BaseViewModel(application)
