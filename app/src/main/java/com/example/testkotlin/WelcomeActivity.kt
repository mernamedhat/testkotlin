package com.example.testkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    lateinit var output: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        output = findViewById(R.id.output)
        sharedPref=  getSharedPreferences("taskandroid", Context.MODE_PRIVATE)
        output.text= "Last name:"+" "+sharedPref.getString("Lastname","0").toString()+ "\n"+
        "Email:"+" "+sharedPref.getString("Email","0").toString()+ "\n"+
        "Password:"+" "+sharedPref.getString("Password","0").toString()+ "\n"


    }
}