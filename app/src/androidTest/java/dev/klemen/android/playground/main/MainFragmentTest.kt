package dev.klemen.android.playground.main

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dev.klemen.android.playground.*
import dev.klemen.android.playground.coroutines.AppDispatchers
import dev.klemen.android.playground.data.TaskResult
import dev.klemen.android.playground.data.TaskRunner
import dev.klemen.android.playground.di.AppModule
import dev.klemen.android.playground.di.NetworkTasks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The AAA (Arrange-Act-Assert) pattern has become almost a standard across the industry. It suggests that you
 * should divide your test method into three sections: arrange, act and assert. Each one of them only responsible
 * for the part in which they are named after.
 *
 * So the arrange section you only have code required to setup that specific test. Here objects would be created,
 * mocks setup (if you are using one) and potentially expectations would be set. Then there is the Act, whic
 * should be the invocation of the method being tested. And on Assert you would simply check whether the
 * expectations were met.
 *
 * @see [taskSuccessful] and [taskFailed]
 *
 * [Source](https://medium.com/@pjbgf/title-testing-code-ocd-and-the-aaa-pattern-df453975ab80)
 */
@ExperimentalCoroutinesApi
@UninstallModules(AppModule::class)
@HiltAndroidTest
class MainFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @NetworkTasks
    lateinit var mockNetworkRunner: TaskRunner

    @Inject
    lateinit var mockAppDispatchers: AppDispatchers

    private lateinit var testDispatcher: TestCoroutineDispatcher

    private val launchIntent = Intent(ApplicationProvider.getApplicationContext(), TestActivity::class.java)
        .apply {
            putExtra(TEST_ACTIVITY_KEY, TEST_FRAGMENT_MAIN)
        }

    @Before
    fun setUp() {
        hiltRule.inject()

        testDispatcher = TestCoroutineDispatcher()
        every { mockAppDispatchers.io } returns testDispatcher
    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun correctSetup() {
        coEvery { mockNetworkRunner.runTask() } returns TaskResult.Completed

        testDispatcher.pauseDispatcher()
        ActivityScenario.launch<TestActivity>(launchIntent)

        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.progress_fetching)))
        testDispatcher.advanceUntilIdle()
    }

    @Test
    fun taskSuccessful() {
        coEvery { mockNetworkRunner.runTask() } returns TaskResult.Success

        ActivityScenario.launch<TestActivity>(launchIntent)

        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.task_success)))
    }

    @Test
    fun taskFailed() {
        coEvery { mockNetworkRunner.runTask() } returns TaskResult.Failure

        ActivityScenario.launch<TestActivity>(launchIntent)

        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.task_failed)))
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    class TestModule {

        @Singleton
        @Provides
        @NetworkTasks
        fun provideMockTaskRunner(): TaskRunner = mockk()

        @Singleton
        @Provides
        fun provideAppDispatchers(): AppDispatchers = mockk()
    }
}
