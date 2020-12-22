package dev.klemen.android.playground.data

interface TaskRunner {

    suspend fun runTask(): TaskResult
}
