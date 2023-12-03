package com.example.testkotlin.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testkotlin.R


class CategoryFragment : Fragment() {

    val args : CategoryFragmentArgs by navArgs()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)


        val cart=view.findViewById<Button>(R.id.cart)
        val categorytext=view.findViewById<TextView>(R.id.categorytext)
//        requireArguments().getString("Argument", "defaultArgumentValue")
        categorytext.text =  requireArguments().getString("Argument", "defaultArgumentValue")
        cart.setOnClickListener {
          //  findNavController().navigate(R.id.)
           // val action = Category.fragmentCartToCategory()
//            navController.navigate(action)
            navController.navigate(R.id.fragment_category_to_cart)

        }
        // findNavController().navigate(CartFragmentDirections.())



    }


}