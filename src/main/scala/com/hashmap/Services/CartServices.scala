package com.hashmap.Services
import Services.CatalogServices
import com.hashmap.dao.CartDao
import com.hashmap.model.{Cart, Catalog}
import model.Item

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
class CartServices(cartDao:CartDao,catalogService:CatalogServices,cart:Cart)
{

//  val obj=new CatalogServices(xmlServices :XmlServices,daoimp :daoimplementation)
 // val xmlServices=new XmlServices
  //val daoimp=new daoimplementation
  def addItemsToCart(id:Int,quantity:Int): Unit =
  {
        val itemsPresent=Catalog.getlistValues()
        val itemget=getItem(itemsPresent,id)
        println(itemget)
        cartDao.addItemsTocart(itemget,quantity)
  }
  def getItem(itemvalue:ListBuffer[Item],id:Int):Item=
  {
    var item1:Item=Item(0,"",0)
     for(i<-itemvalue)
      {
        if(i.id==id)
          {
            item1= i
          }
      }
     item1
  }
  def showCartItems():mutable.Map[Item,Int] =
  {
    cartDao.getCartItems
  }
  def removeFromCart(id:Int, quantity:Int):Unit=
  {
    cartDao.removeItemsfromCart(id,quantity)
  }

  def updateCart():Unit=
  {

  }
  def CalculateBill(): mutable.Map[(Item,Int),Double] =
  {
    cart.setCartItems(cartDao.calculteBillofIndividualItem)
    cartDao.calculteBillofIndividualItem
  }
  def generateOrderSummary:Option[((mutable.Map[Item,Int]),(Double))]=
  {
    val itemsPresent=cartDao.getCartItems
    catalogService.updateStock(itemsPresent)
    println(cart.getCartItems)
    cartDao.getCheckOutBill
  }

 }
