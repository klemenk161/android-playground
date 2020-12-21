package dev.klemen.android.playground.main

import androidx.test.core.app.ActivityScenario
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
import dev.klemen.android.playground.R
import dev.klemen.android.playground.TestActivity
import dev.klemen.android.playground.data.NetworkTaskRunner
import dev.klemen.android.playground.data.TaskResult
import dev.klemen.android.playground.data.TaskRunner
import dev.klemen.android.playground.di.AppModule
import dev.klemen.android.playground.di.NetworkTasks
import dev.klemen.android.playground.ui.main.MainFragment
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
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
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @NetworkTasks
    lateinit var mockNetworkRunner: TaskRunner

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var scenario: ActivityScenario<TestActivity>
    private lateinit var mainFragment: MainFragment

    @Before
    fun setUp() {
        hiltRule.inject()
        Dispatchers.setMain(testDispatcher)
        scenario = ActivityScenario.launch(TestActivity::class.java)
        mainFragment = MainFragment.newInstance()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun correctSetup() = runBlockingTest {
        arrange {
            testDispatcher.pauseDispatcher()
            coEvery { mockNetworkRunner.runTask() } returns TaskResult.Completed
        }

        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.progress_fetching)))
    }

    @Test
    fun taskSuccessful() = runBlockingTest {
        // Arrange
        arrange { coEvery { mockNetworkRunner.runTask() } returns TaskResult.Success }

        // Act
        testDispatcher.advanceUntilIdle()

        // Assert
        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.task_success)))
    }

    @Test
    fun taskFailed() = runBlockingTest {
        // Arrange
        arrange { coEvery { mockNetworkRunner.runTask() } returns TaskResult.Failure }

        // Act
        testDispatcher.advanceUntilIdle()

        // Assert
        onView(withId(R.id.mainProgress)).check(matches(withText(R.string.task_failed)))
    }

    private fun arrange(conditions: () -> Unit) = scenario.onActivity {
        conditions()
        it.addFragment(mainFragment)
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    class TestModule {

        @Singleton
        @Provides
        @NetworkTasks
        fun provideMockTaskRunner(): TaskRunner = mockk<NetworkTaskRunner>()
    }
}
