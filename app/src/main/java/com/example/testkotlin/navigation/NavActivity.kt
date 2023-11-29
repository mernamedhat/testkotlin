package com.example.testkotlin.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.testkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavActivity : AppCompatActivity() {
    //private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)

       // navController = findNavController(R.id.nav_host_fragment)

    }
}