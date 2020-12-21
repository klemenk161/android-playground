package dev.klemen.android.playground.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){

    private val context: Context by lazy { getApplication() }

    protected fun getString(stringId: Int) = context.getString(stringId)
}