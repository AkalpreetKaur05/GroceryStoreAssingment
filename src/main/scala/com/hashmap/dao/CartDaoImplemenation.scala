package com.hashmap.dao
import com.hashmap.Database.CartRepo
import model.Item

import scala.collection.mutable

class CartDaoImplemenation extends CartDao
{
 def addItemsTocart(item:Item, quantity:Int): Unit =
  {
    (CartRepo.itemBought)+=(item->quantity)
    CartRepo.bill=item.price*quantity
    CartRepo.billCalIndividualItem+=((item->quantity)->CartRepo.bill)
    //DatabaseRepo.personalCartItems+=(id->DatabaseRepo.itemBought)
  }
  def getCartItems:mutable.Map[Item,Int]=
  {
    println("items bought are "+CartRepo.itemBought)
    CartRepo.itemBought
  }
  def calculteBillofIndividualItem:mutable.Map[(Item,Int),Double]=
  {
    CartRepo.billCalIndividualItem
  }
  def removeItemsfromCart(id:Int,quantity:Int): Unit = {
    val itemValue=isItemPresentInCart(id)
    if (CartRepo.itemBought.keySet.contains(itemValue._1)) {
      val quantityBuyed = CartRepo.itemBought.get(itemValue._1)
      val quantityBuyedNew = quantityBuyed match {
        case Some(x) => x
        case None => 0
      }
      if (quantityBuyedNew == 0) {
        CartRepo.itemBought -= itemValue._1
      }
      val quantityNew = (quantityBuyedNew) - quantity
      if(quantityNew==0)
      {
        CartRepo.itemBought-=itemValue._1
      }
      var billofindividualitem = itemValue._1.price * quantityNew
      CartRepo.itemBought.update(itemValue._1, quantityNew)
      val updateBill=updateItemBill(itemValue._1)
      CartRepo.billCalIndividualItem.update((itemValue._1->quantityBuyedNew),billofindividualitem)
    }
  }
  def isItemPresentInCart(id: Int): (Item,Int) =
  {
     val cartItems=CartRepo.itemBought.find(x=>x._1.id==id)match
      {
        case Some(x)=>x
      }
    cartItems
  }
  def updateItemBill(item: Item):((Item,Int),Double)=
  {
    val itemBill=CartRepo.billCalIndividualItem.find(x=>x._1._1==item)match
      {
      case Some(x)=>x
      }
    itemBill
  }


    def getCheckOutBill:Option[(mutable.Map[Item,Int],Double)]=
    {
     val total:List[Double]= (((CartRepo.billCalIndividualItem).values).toList)
      val totalNew=sumList(total)

      Some(CartRepo.itemBought,totalNew)
      }

    def sumList(xs:List[Double]):Double={
      xs match {
        case head :: tail => head + sumList(tail)
        case Nil => 0
      }
      }



}
