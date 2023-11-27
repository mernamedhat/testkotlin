package com.example.testkotlin.bottomnavbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.testkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
//        val BottomNav=findViewById<BottomNavigationView>(R.id.bottomNav)
//        BottomNav.setOnItemReselectedListener { item ->
//            when(item.itemId) {
//                R.id.homeFragment -> {
//                   supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragment()).commit()
//                }
//                R.id.searchFragment -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.container,SearchFragment()).commit()
//                }
//                R.id.favouriteFragment -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.container,FavoriteFragment()).commit()
//                }
//            }
//        }
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.searchFragment -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.favouriteFragment -> {
                    loadFragment(FavoriteFragment())
                    true
                }


                else -> {
                   true
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
    }
