package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var back: ImageView
    lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        back = findViewById(R.id.back)
        output = findViewById(R.id.output)

        back.setOnClickListener { finish() }

        val i = intent
        val result = i.getStringExtra("Age")
        output.text=result.toString()
    }
}