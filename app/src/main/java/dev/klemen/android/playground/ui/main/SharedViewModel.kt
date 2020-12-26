package dev.klemen.android.playground.ui.main

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.klemen.android.playground.R
import dev.klemen.android.playground.coroutines.AppDispatchers
import dev.klemen.android.playground.data.TaskRunner
import dev.klemen.android.playground.di.NetworkTasks
import dev.klemen.android.playground.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SharedViewModel @ViewModelInject constructor(
    application: Application
) : BaseViewModel(application) {


}
