package com.example.testkotlin

data class Model (var name:String,
                  val InvDet_I_ID: String,
                  var InvDet_Qty: Int,
                  var InvDet_Item_Notes_details: String="",
                  var state:Boolean
               )