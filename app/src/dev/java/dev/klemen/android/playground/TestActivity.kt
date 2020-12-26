package dev.klemen.android.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.ui.home.HomeFragment
import dev.klemen.android.playground.ui.learn.LearnFragment
import dev.klemen.android.playground.ui.profile.ProfileFragment

const val TEST_ACTIVITY_KEY = "TestActivityTag"
const val TEST_ACTIVITY_BUNDLE = "TestActivityBundle"

const val TEST_FRAGMENT_HOME = "dev.klemen.android.playground.ui.home.HomeFragment"
const val TEST_FRAGMENT_LEARN = "dev.klemen.android.playground.ui.learn.LearnFragment"
const val TEST_FRAGMENT_PROFILE = "dev.klemen.android.playground.ui.profile.ProfileFragment"

/**
 * Blank Activity to run tests on Fragments in an isolated environment.
 * Always make your Fragments activity-independent.
 *
 * If you need to communicate with your Host Activity, use Interfaces or now preferably SharedViewModels.
 *
 * [SharedViewModel Documentation](https://developer.android.com/guide/fragments/communicate)
 */
@AndroidEntryPoint
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val fragment = when(val fragmentTag = intent.getStringExtra(TEST_ACTIVITY_KEY)) {
            TEST_FRAGMENT_HOME -> HomeFragment.newInstance()
            TEST_FRAGMENT_LEARN -> LearnFragment()
            TEST_FRAGMENT_PROFILE -> ProfileFragment()
            else -> throw NoSuchElementException("No such fragment: $fragmentTag")
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.testFragmentContainer, fragment)
            .commitNow()
    }
}
