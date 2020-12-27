package dev.klemen.android.playground.home

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isSelected
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dev.klemen.android.playground.R
import dev.klemen.android.playground.TEST_ACTIVITY_KEY
import dev.klemen.android.playground.TEST_FRAGMENT_HOME
import dev.klemen.android.playground.TestActivity
import dev.klemen.android.playground.di.HomeModule
import org.hamcrest.Matchers.not
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(HomeModule::class)
class HomeFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var scenario: ActivityScenario<TestActivity>

    @Before
    fun setUp() {
        hiltRule.inject()
        scenario = ActivityScenario.launch(
            Intent(ApplicationProvider.getApplicationContext(), TestActivity::class.java)
                .apply {
                    putExtra(TEST_ACTIVITY_KEY, TEST_FRAGMENT_HOME)
                }
        )
    }

    @Test
    fun correctSetup() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
        onView(withText(R.string.home_tab_available)).check(matches(isSelected()))
        onView(withText(R.string.home_tab_progress)).check(matches(not(isSelected())))
    }

    @Test
    fun clickOnProgressTab() {
        onView(withText(R.string.home_tab_progress)).perform(click())

        onView(withText(R.string.home_tab_available)).check(matches(not(isSelected())))
        onView(withText(R.string.home_tab_progress)).check(matches(isSelected()))
    }

    @Module
    @InstallIn(FragmentComponent::class)
    class TestModule {

        @Provides
        fun provideAdapter(activity: FragmentActivity): FragmentStateAdapter {
            val fragments = listOf(Fragment(), Fragment())
            return object : FragmentStateAdapter(activity) {
                override fun createFragment(position: Int): Fragment = fragments[position]

                override fun getItemCount(): Int = fragments.size
            }
        }
    }
}
