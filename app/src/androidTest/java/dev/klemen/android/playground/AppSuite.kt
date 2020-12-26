package dev.klemen.android.playground

import dev.klemen.android.playground.home.HomeSuite
import dev.klemen.android.playground.main.MainSuite
import dev.klemen.android.playground.profile.ProfileSuite
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainSuite::class,
    HomeSuite::class,
    ProfileSuite::class
)
class AppSuite
