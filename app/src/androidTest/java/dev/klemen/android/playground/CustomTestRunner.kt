package dev.klemen.android.playground

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * A custom Runner with [HiltTestApplication] instead of default Application.
 *
 * [Documentation](https://developer.android.com/training/dependency-injection/hilt-testing#ui-test)
 */
class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}
