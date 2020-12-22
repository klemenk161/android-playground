package dev.klemen.android.playground.data

sealed class TaskResult {
    object Success : TaskResult()
    object Completed : TaskResult()
    object Failure : TaskResult()

    val didSucceed: Boolean
        get() = this is Success
}
