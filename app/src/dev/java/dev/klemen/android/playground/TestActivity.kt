package dev.klemen.android.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.klemen.android.playground.ui.main.MainFragment

const val TEST_ACTIVITY_KEY = "TestActivityTag"
const val TEST_ACTIVITY_BUNDLE = "TestActivityBundle"

const val TEST_FRAGMENT_MAIN = "dev.klemen.android.playground.ui.main.MainFragment"

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
            TEST_FRAGMENT_MAIN -> MainFragment.newInstance()
            else -> throw NoSuchElementException("No such fragment: $fragmentTag")
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.testFragmentContainer, fragment)
            .commitNow()
    }
}
