package dev.klemen.android.playground.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.klemen.android.playground.data.NetworkTaskRunner
import dev.klemen.android.playground.data.TaskRunner
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    @NetworkTasks
    abstract fun bindNetworkTaskRunner(networkTaskRunner: NetworkTaskRunner): TaskRunner
}
