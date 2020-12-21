package dev.klemen.android.playground.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkTasks

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DbTasks
