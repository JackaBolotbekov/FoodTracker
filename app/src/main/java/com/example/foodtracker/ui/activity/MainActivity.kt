package com.example.foodtracker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodtracker.R
import com.example.foodtracker.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}