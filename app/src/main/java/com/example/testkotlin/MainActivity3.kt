package com.example.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import java.util.Calendar

class MainActivity3 : AppCompatActivity() {
//    lateinit var drawerLayout: DrawerLayout
//    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
lateinit var ok: Button
lateinit var input: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        ok = findViewById(R.id.ok)
        input = findViewById(R.id.input)
        ok.setOnClickListener {
            val currentDate = Calendar.getInstance().get(Calendar.YEAR);
            if (input.text.equals(null)||input.text.isEmpty()){
                Toast.makeText(this, "error input! ", Toast.LENGTH_SHORT).show()
            }else{
                val res = currentDate - input.text.toString().trim().toInt()

                val i = Intent(this,MainActivity4::class.java)
                i.putExtra("Age",res.toString())
                startActivity(i)
            }

        }

//        drawerLayout = findViewById(R.id.my_drawer_layout)
//        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
//
//        // pass the Open and Close toggle for the drawer layout listener
//        // to toggle the button
//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()
//
//        // to make the Navigation drawer icon always appear on the action bar
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//
//            true
//        } else super.onOptionsItemSelected(item)
//    }
}