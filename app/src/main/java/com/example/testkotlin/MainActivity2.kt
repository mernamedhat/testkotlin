package com.example.testkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.util.Calendar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val Firstname = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val Lastname = findViewById<EditText>(R.id.lastName)
        val Email = findViewById<EditText>(R.id.userEmail)
        val Password = findViewById<EditText>(R.id.password)


        //Shared
        val preferences: SharedPreferences =
            this.getSharedPreferences("taskandroid", Context.MODE_PRIVATE)
        // access the spinner
        val Education = arrayOf(
            "Fci",
            "Commerce College",
            "Art University",
            "College of education",
            "College of Engineering",
            "School of Law"
        )

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, Education
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    preferences.edit().putString("Education", Education[position]).apply()
                    Toast.makeText(
                        this@MainActivity2,
                        "selected_item" + " " +
                                "" + Education[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //button
        val confirm = findViewById<Button>(R.id.ConfirmBtn)
        confirm.setOnClickListener {
            preferences.edit().putString("Firstname", Firstname.text.toString().trim()).apply()
            preferences.edit().putString("Lastname", Lastname.text.toString().trim()).apply()
            preferences.edit().putString("Email", Email.text.toString().trim()).apply()
            preferences.edit().putString("Password", Password.text.toString().trim()).apply()
            val CheckBox = findViewById<CheckBox>(R.id.terms_conditions)

            if (CheckBox.isChecked) {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this@MainActivity2,
                    "select the  CheckBox", Toast.LENGTH_SHORT
                ).show()
            }


        }

        //access the autoCompleteTextView
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.select_dialog_item, Education)
        val actv = findViewById<View>(R.id.autoCompleteTextView) as AutoCompleteTextView

        actv.setAdapter(adapter)
        actv.setTextColor(Color.RED)
    }
}