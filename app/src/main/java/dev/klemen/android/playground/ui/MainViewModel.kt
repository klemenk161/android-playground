package dev.klemen.android.playground.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.klemen.android.playground.R
import dev.klemen.android.playground.base.BaseViewModel

class MainViewModel(application: Application) : BaseViewModel(application) {

    private val _mainText = MutableLiveData<String>()

    val mainText: LiveData<String> = _mainText

    fun fetchData() {
        _mainText.value = getString(R.string.progress_fetching)
    }
}