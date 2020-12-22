package dev.klemen.android.playground

import dev.klemen.android.playground.main.MainSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainSuite::class
)
class AppSuite
