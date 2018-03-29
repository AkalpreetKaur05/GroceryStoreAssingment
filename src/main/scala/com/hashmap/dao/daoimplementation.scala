package com.hashmap.dao
import com.hashmap.model.Stock
import dao.{CatalogRepo, daomain}
import model.Item

import scala.collection.mutable.ListBuffer

class daoimplementation extends daomain
{
  def addItems(stock:Stock): Unit =
  {
    //println(item)
    CatalogRepo.addItemsRepo(stock)
  }
  /*def removeItems(stock: Stock): Unit =
  {
    CatalogRepo.removefromStock(stock)
  }*/
  def getItems():ListBuffer[Item]=
  {
    CatalogRepo.getItemRepo()
  }
  /*def getStock():ListBuffer[Stock]=
  {
    CatalogRepo.getItemStock()
  }*/
  /*def addItemstocart(cart:Cart): Unit =
  {
    (CatalogRepo.itemBought)+=(cart.Item->cart.quantity)
    //DatabaseRepo.personalCartItems+=(id->DatabaseRepo.itemBought)
  }
  def getCartItems:mutable.Map[Item,Int]=
  {
    println("items bought are "+CatalogRepo.itemBought)
    CatalogRepo.itemBought
  }*/


}
