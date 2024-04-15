package com.example.testkotlin.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


import com.example.testkotlin.R


class CartFragment : Fragment() {
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)


        val Cate=view.findViewById<Button>(R.id.Cate)
        Cate.setOnClickListener {

           // val action = CartFragmentDirections.fragmentCartToCategory("ggg")
            navController.navigate(R.id.fragment_cart_to_Category)


//            val action = CartFragmentDirections.fragmentCartToCategory("Your string here")
//            navController.navigate(action)

//            val action = CartFragmentDirections.fragmentCartToCategory("ggg")
//            navController.navigate(action)



            }
       // findNavController().navigate(CartFragmentDirections.())



    }


}