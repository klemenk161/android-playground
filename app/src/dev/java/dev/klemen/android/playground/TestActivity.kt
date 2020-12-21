package dev.klemen.android.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

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
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.testFragmentContainer, fragment)
            .commitNow()
    }
}
