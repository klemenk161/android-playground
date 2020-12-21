package dev.klemen.android.playground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.klemen.android.playground.R
import dev.klemen.android.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainSetup()
    }

    private fun mainSetup() {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainFragmentContainer, MainFragment.newInstance())
            .commitNow()
    }
}
