package dev.klemen.android.playground.extensions

fun <T : Any>T.setup(block: T.() -> Unit) = block()
