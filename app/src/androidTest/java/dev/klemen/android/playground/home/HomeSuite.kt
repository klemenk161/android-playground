package dev.klemen.android.playground.home

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    HomeFragmentTest::class,
    AvailablePageFragmentTest::class,
    ProgressPageFragmentTest::class
)
class HomeSuite
