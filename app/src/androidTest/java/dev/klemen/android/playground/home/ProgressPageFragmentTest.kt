package dev.klemen.android.playground.home

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.klemen.android.playground.R
import dev.klemen.android.playground.TEST_ACTIVITY_KEY
import dev.klemen.android.playground.TEST_PAGE_HOME_PROGRESS
import dev.klemen.android.playground.TestActivity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ProgressPageFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var scenario: ActivityScenario<TestActivity>

    private val launchIntent = Intent(ApplicationProvider.getApplicationContext(), TestActivity::class.java)
        .apply {
            putExtra(TEST_ACTIVITY_KEY, TEST_PAGE_HOME_PROGRESS)
        }

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun correctSetup() {
        scenario = ActivityScenario.launch(launchIntent)

        assertEquals(Lifecycle.State.RESUMED, scenario.state)
        onView(withText(R.string.hello_blank_fragment)).check(matches(isCompletelyDisplayed()))
    }
}
