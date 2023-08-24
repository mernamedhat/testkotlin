package com.example.testkotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter
    private val itemListt: ArrayList<Model> = ArrayList()

    private lateinit var mergeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        mergeButton=findViewById(R.id.mergeButton)
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemListt.add(Model("Item 1","1",1,"",false))
        itemListt.add(Model("Item 2","1",1,"",false))
        itemListt.add(Model("Item 3","1",1,"",false))
        itemListt.add(Model("Item 4","2",1,"",false))
        itemListt.add(Model("Item 5","2",1,"",false))
        mergeButton.setOnClickListener {
           customAdapter.mergeItemsWithSameIds()
            customAdapter.notifyDataSetChanged()
        }
        customAdapter = CustomAdapter(this, itemListt)
        recyclerView.adapter = customAdapter
    }
}
//class Department(val id: Int, val name: String, val note: String, var count: Int)
//
//class MainActivity : AppCompatActivity() {
//    private val departmentList = mutableListOf<Department>()
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: DepartmentAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = DepartmentAdapter(departmentList)
//        recyclerView.adapter = adapter
//
//        // Add sample department data
//        departmentList.add(Department(1, "Department A", "", 5))
//        departmentList.add(Department(2, "Department B", "", 3))
//        departmentList.add(Department(1, "ةثقىش", "Note 1", 2))
//        departmentList.add(Department(1, "Department A", "", 5))
//        departmentList.add(Department(2, "Department B", "", 3))
//        departmentList.add(Department(1, "اااا", "Note 1", 2))
//        departmentList.add(Department(1, "Department A", "", 5))
//        departmentList.add(Department(1, "Department A", "", 5))
//        departmentList.add(Department(1, "Department A", "", 5))
//
//
//
//        adapter.notifyDataSetChanged()
//
//        val mergeButton = findViewById<Button>(R.id.mergeButton)
//        mergeButton.setOnClickListener {
//            mergeDepartments()
//            adapter.notifyDataSetChanged()
//        }
//    }
//
//    private fun mergeDepartments() {
//        val mergedList = mutableListOf<Department>()
//        val mergedIds = mutableSetOf<Int>()
//
//        for (department in departmentList) {
//            if (department.note.isEmpty()) {
//                val existingDepartment = mergedList.find { it.id == department.id }
//                if (existingDepartment != null) {
//                    existingDepartment.count = existingDepartment.count+1
//               //  mergedIds.add(department.id)
//                } else {
//                    mergedList.add(department)
//                }
//            } else {
//                mergedList.add(department)
//            }
//        }
//        departmentList.clear()
//       // departmentList.retainAll { it.note.isNotEmpty() || it.id !in mergedIds }
//        departmentList.addAll(mergedList)
//    }
//}
//
//class DepartmentAdapter(private val departmentList: List<Department>) :
//    RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>() {
//
//    class DepartmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
//        val countTextView: TextView = view.findViewById(R.id.countTextView)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.department_item, parent, false)
//        return DepartmentViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
//        val department = departmentList[position]
//        holder.nameTextView.text = "Name: ${department.name}"
//        holder.countTextView.text = "Count: ${department.count}"
//    }
//
//    override fun getItemCount(): Int {
//        return departmentList.size
//    }
//}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//package com.example.ichef.ui.department_details
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.core.content.ContentProviderCompat.requireContext
//import androidx.core.content.ContextCompat
//import androidx.recyclerview.widget.RecyclerView
//import com.example.ichef.R
//import com.example.ichef.api.model.DepartmentDetails
//import com.example.ichef.databinding.DepartmentCategoryDetailsItemBinding
//
//
//class DepartmentDetailsAdapter(
//    var DepartmentDetailsList: List<DepartmentDetails>,
//    private var context: Context,
//    var Title: String?,
//    ItemClickListener: ItemClickListener?
//) : RecyclerView.Adapter<DepartmentDetailsAdapter.ViewHolder>() {
//
//    private lateinit var binding: DepartmentCategoryDetailsItemBinding
//    private var listener: ItemClickListener
//
//
//    init {
//
//        this.listener = ItemClickListener!!
//
//    }
//
//    interface ItemClickListener {
//        fun onItemClick(
//            item: DepartmentDetails, iCost: Double
//        )
//
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup, viewType: Int
//    ): DepartmentDetailsAdapter.ViewHolder {
//        binding = DepartmentCategoryDetailsItemBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
//        )
//        return ViewHolder()
//    }
//
//    override fun onBindViewHolder(holder: DepartmentDetailsAdapter.ViewHolder, position: Int) {
//
//        holder.setData(DepartmentDetailsList[position], position)
//        holder.setIsRecyclable(false)
//
//    }
//
//    override fun getItemCount() = DepartmentDetailsList.size
//
//    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
//        @SuppressLint("ResourceType", "SuspiciousIndentation", "SetTextI18n")
//        fun setData(item: DepartmentDetails, position: Int) {
//
//            binding.apply {
//                Log.d("InvDet_Qty", item.InvDet_Qty.toString())
//                if (item.InvDet_Qty==0){
//                    item.InvDet_Qty+1
//                }
//
//                cardview.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        itemView.context, R.color.white
//                    )
//                )
//                Txt.text = Title
//                type.text = item.I_Name
//                price.text = item.InvDet_Cost.toString() + " جنية"
//                item.Tcount=1
//                binding.root.setOnClickListener {
//                    count.visibility = View.VISIBLE
//                    if (item.InvDet_Qty==0){
//                        item.InvDet_Qty+1
//                    }
//                    Log.d("InvDet_Qty", item.InvDet_Qty.toString())
//                        if (item.count < item.iq_qty) {
//
//                            Log.d("itemcounttt", item.count.toString())
//                            item.count++
//                            Log.d("itemcountttt", item.count.toString())
//
//                            listener.onItemClick(item, item.InvDet_Cost)
//                        }else{
//                            Toast.makeText(context, "No Quantity Enough", Toast.LENGTH_SHORT).show()
//                        }
//
//                    cardview.setCardBackgroundColor(
//                        ContextCompat.getColor(
//                            itemView.context, R.color.leather
//                        )
//                    )
//
//                    Txt.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
//                    price.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
//                    type.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
//                    count.text = "x" + item.count
//                }
//
//
//            }
//        }
//
//    }
//
//
//}