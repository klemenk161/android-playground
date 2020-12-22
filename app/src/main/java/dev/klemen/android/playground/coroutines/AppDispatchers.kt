package dev.klemen.android.playground.coroutines

import kotlinx.coroutines.Dispatchers

class AppDispatchers {
    val main = Dispatchers.Main.immediate
    val io = Dispatchers.IO
}
