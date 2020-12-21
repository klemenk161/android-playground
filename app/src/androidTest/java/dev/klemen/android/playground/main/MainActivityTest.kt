package dev.klemen.android.playground.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.klemen.android.playground.R
import dev.klemen.android.playground.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun correctSetup() {
        onView(withId(R.id.mainFragmentContainer)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}