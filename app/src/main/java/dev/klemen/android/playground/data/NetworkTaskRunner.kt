package dev.klemen.android.playground.data

import kotlinx.coroutines.delay
import javax.inject.Inject

private const val SIMULATED_DELAY = 2500L

class NetworkTaskRunner @Inject constructor() : TaskRunner {

    override suspend fun runTask(): TaskResult {
        delay(SIMULATED_DELAY)
        return TaskResult.Success
    }
}
