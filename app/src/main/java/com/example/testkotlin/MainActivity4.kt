package com.example.testkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var back: ImageView
    lateinit var output: TextView
    private lateinit var sharedPref: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        back = findViewById(R.id.back)
        output = findViewById(R.id.output)
        sharedPref=  getSharedPreferences("taskandroid", Context.MODE_PRIVATE)

        back.setOnClickListener { finish() }

//        val i = intent
//        val result = i.getStringExtra("Age")
       // output.text=result.toString()
        output.text= sharedPref.getInt("years",0).toString()
    }
}