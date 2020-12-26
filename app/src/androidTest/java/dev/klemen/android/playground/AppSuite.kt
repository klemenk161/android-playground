package dev.klemen.android.playground

import dev.klemen.android.playground.home.HomeSuite
import dev.klemen.android.playground.main.MainSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainSuite::class,
    HomeSuite::class,
)
class AppSuite
