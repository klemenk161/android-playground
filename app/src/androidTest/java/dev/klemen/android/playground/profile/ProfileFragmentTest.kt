package dev.klemen.android.playground.profile

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.klemen.android.playground.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ProfileFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private val launchIntent = Intent(ApplicationProvider.getApplicationContext(), TestActivity::class.java)
        .apply {
            putExtra(TEST_ACTIVITY_KEY, TEST_FRAGMENT_PROFILE)
        }

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun correctSetup() {
        ActivityScenario.launch<TestActivity>(launchIntent)

        onView(withText(R.string.hello_blank_fragment)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }
}
