package com.example.bookmovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookmovie.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragmentHome)
            .commit()

    }
}