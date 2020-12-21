package dev.klemen.android.playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.klemen.android.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
