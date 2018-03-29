package com.hashmap.dao

import model.Item

import scala.collection.mutable
trait  CartDao
{
  def addItemsTocart(item: Item, quantity:Int): Unit
  def getCartItems:mutable.Map[Item,Int]
  def calculteBillofIndividualItem:mutable.Map[(Item,Int),Double]
  def removeItemsfromCart(id:Int,quantity:Int): Unit
  def getCheckOutBill:Option[(mutable.Map[Item,Int],Double)]
}
