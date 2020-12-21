package dev.klemen.android.playground.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.klemen.android.playground.R
import dev.klemen.android.playground.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class MainActivityTest {

    private val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(hiltRule)
        .around(ActivityScenarioRule(MainActivity::class.java))

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun correctSetup() {
        onView(withId(R.id.mainFragmentContainer)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}
