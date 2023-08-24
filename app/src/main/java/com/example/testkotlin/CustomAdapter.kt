package com.example.testkotlin

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private var itemList: ArrayList<Model>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private lateinit var itemListt: ArrayList<Model>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        itemListt=  ArrayList()
        holder.editText.setText(item.InvDet_Item_Notes_details)
        holder.count.text= item.InvDet_Qty.toString()

        holder.editButton.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(context)
            val dialogView = LayoutInflater.from(context).inflate(R.layout.edit_dialog, null)
            val editText = dialogView.findViewById<EditText>(R.id.editTextDialog)
            val saveButton = dialogView.findViewById<Button>(R.id.saveButton)

            editText.setText(item.name)

            dialogBuilder.setView(dialogView)
            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            saveButton.setOnClickListener {
                item.InvDet_Item_Notes_details = editText.text.toString()
                holder.editText.setText(item.InvDet_Item_Notes_details)
                alertDialog.dismiss()
            }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun mergeItemsWithSameIds() {
        for (item in itemList) {
            val existingItem = itemListt.find { it.InvDet_I_ID == item.InvDet_I_ID }
            Log.d("InvDet_Item", item.InvDet_Item_Notes_details+" "+item.InvDet_I_ID+" "+existingItem?.InvDet_Item_Notes_details+existingItem)
            if (existingItem != null) {
//                Log.d("InvDet_Item", item.InvDet_Item_Notes_details+" "+existingItem.InvDet_Item_Notes_details)
                if (item.InvDet_Item_Notes_details.isEmpty()&& existingItem.state) {
                    Log.d("InvDet", item.InvDet_Item_Notes_details)
                    (existingItem.InvDet_Qty)++
                } else {
                    Log.d("Inv", item.InvDet_Item_Notes_details)
                    itemListt.add(item)
                    existingItem.state=true
                }

            } else {

                itemListt.add(item)


            }
        }
        itemList.clear()
        itemList = itemListt

        notifyDataSetChanged()


    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val editText: EditText = itemView.findViewById(R.id.editText)
        val editButton: Button = itemView.findViewById(R.id.editButton)
        val count: TextView = itemView.findViewById(R.id.count)

    }
}