package com.hashmap.model

import model.Item

import scala.collection.mutable

case class Cart()
{
 private var itemsinCartori=mutable.Map[(Item,Int),Double]()
  def setCartItems(itemsincart:mutable.Map[(Item,Int),Double]): Unit =
  {
    itemsinCartori=itemsincart
  }
  def getCartItems:mutable.Map[(Item,Int),Double]=
  {
    itemsinCartori
  }
}




