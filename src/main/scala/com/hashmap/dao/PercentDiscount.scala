package com.hashmap.dao
import com.hashmap.Database.discountRepo
import com.hashmap.Exceptions.NoDiscountOnItemException
import com.hashmap.model.Catalog
import scala.util.{Failure, Success, Try}
class PercentDiscount extends DiscountDao
{
  def addDiscounts(itemid:Int,minimumquantityitem:Int,percentdiscount:Double ): Unit =
  {
    if(IsItemPresent(itemid)) {
      id = itemid
      percentagediscount = percentdiscount
      minimumquantity = minimumquantityitem
      discountRepo.itemperdiscount += ((id, minimumquantity) -> percentagediscount)
    }
  }
   def removeDiscounts(itemid:Int): Unit =
  {
   val discountedItem= IsDiscountPresent(itemid)match
    {
      case Success(x)=>x
      case Failure(e)=>throw new NoDiscountOnItemException("no discount on this item is available" )
    }
    discountRepo.itemperdiscount-=(discountedItem._1)
  }
  def IsItemPresent(id:Int):Boolean=
    {
     if(Catalog.getlistValues().contains(id))
       {
         return true
       }
      else{return false}
    }
  def IsDiscountPresent(itemid: Int): Try[((Int,Int),Double)] =
  {Try({
      discountRepo.itemperdiscount.find(x => x._1._1 == itemid) match {
        case Some(x) => x
      }
    })
  }
}


