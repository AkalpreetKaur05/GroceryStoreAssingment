package com.hashmap.Services

import com.hashmap.dao.PercentDiscount

class AdminServices
{
 def addDiscounts(id:Int,minimumquantity:Int,freequantity:Int,percent:Double):Unit=
 {
  if(freequantity==0)
   {
    val percentdiscountonitem=(new PercentDiscount).addDiscounts(id,minimumquantity,percent)
   }

 }
 //def viewDiscounts:[(Int,Int),Double]

}
