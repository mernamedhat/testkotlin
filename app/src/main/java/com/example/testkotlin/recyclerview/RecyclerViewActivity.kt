package com.example.testkotlin.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.Model
import com.example.testkotlin.R

class RecyclerViewActivity : AppCompatActivity() {
    private val itemList: ArrayList<data> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        itemList.add(data(R.drawable.logo, "Item " ))
        itemList.add(data(R.drawable.logo, "Item " ))
        itemList.add(data(R.drawable.logo, "Item " ))
        itemList.add(data(R.drawable.logo, "Item " ))
        itemList.add(data(R.drawable.logo, "Item " ))

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val adapter = Adapter(itemList)
        recyclerview.adapter = adapter
    }
}