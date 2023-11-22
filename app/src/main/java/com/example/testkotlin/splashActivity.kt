package com.example.testkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import java.util.Timer
import java.util.TimerTask

class splashActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPref=  getSharedPreferences("taskandroid", Context.MODE_PRIVATE)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                if (sharedPref.getString("Lastname","").toString().isNotEmpty()){
                    val intent = Intent(this@splashActivity, WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                val intent = Intent(this@splashActivity, MainActivity2::class.java)
                startActivity(intent)
                finish()}
            }
        }, 3000)

    }
}