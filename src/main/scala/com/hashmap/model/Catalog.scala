package com.hashmap.model

import model.Item

import scala.collection.mutable.ListBuffer

object Catalog
{
  //val daoimp=new daoimplementation
  private var itemList=ListBuffer[Item]()
  def setlistValues(lstitem:ListBuffer[Item])
  {
     itemList=lstitem
  }
  def getlistValues(): ListBuffer[Item] =
  {
      itemList
  }
}
 //case class Catalog(item: Item)