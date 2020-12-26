package dev.klemen.android.playground.ui.learn

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel

class LearnViewModel @ViewModelInject constructor(
    application: Application
) : AndroidViewModel(application)
