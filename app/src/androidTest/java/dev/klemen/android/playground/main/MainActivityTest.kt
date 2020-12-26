package dev.klemen.android.playground.main

import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.klemen.android.playground.ui.main.MainActivity
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class MainActivityTest {

    private val hiltRule = HiltAndroidRule(this)
    private val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(hiltRule).around(scenarioRule)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun correctSetup() {
        assertEquals(scenarioRule.scenario.state, Lifecycle.State.RESUMED)
    }
}
