package com.example.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import java.util.Timer
import java.util.TimerTask

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@splashActivity, MainActivity3::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)

    }
}