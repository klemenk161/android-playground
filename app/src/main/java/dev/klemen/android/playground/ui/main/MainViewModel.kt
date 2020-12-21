package dev.klemen.android.playground.ui.main

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.klemen.android.playground.R
import dev.klemen.android.playground.data.TaskRunner
import dev.klemen.android.playground.di.NetworkTasks
import dev.klemen.android.playground.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    application: Application,
    @NetworkTasks private val taskRunner: TaskRunner
) : BaseViewModel(application) {

    private val _mainText = MutableLiveData<String>()

    val mainText: LiveData<String> = _mainText

    fun fetchData() {
        _mainText.value = getString(R.string.progress_fetching)
        viewModelScope.launch {
            val taskResult = taskRunner.runTask()
            _mainText.postValue(
                getString(
                    if(taskResult.didSucceed)
                        R.string.task_success
                    else
                        R.string.task_failed
                )
            )
        }
    }
}
