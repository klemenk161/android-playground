package dev.klemen.android.playground.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.klemen.android.playground.coroutines.AppDispatchers
import dev.klemen.android.playground.data.NetworkTaskRunner
import dev.klemen.android.playground.data.TaskRunner
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun bindDispatchers(): AppDispatchers = AppDispatchers()

    @Singleton
    @NetworkTasks
    @Provides
    fun bindNetworkTaskRunner(): TaskRunner = NetworkTaskRunner()
}
