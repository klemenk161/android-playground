package dev.klemen.android.playground.main

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.klemen.android.playground.R
import dev.klemen.android.playground.ui.MainFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    private lateinit var scenario: FragmentScenario<MainFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer { MainFragment.newInstance() }
    }

    @Test
    fun correctSetup() {
        scenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.progress_fetching)))
    }
}
