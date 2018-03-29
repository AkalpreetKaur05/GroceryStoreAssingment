package com.hashmap.dao
import com.hashmap.model.Stock

import scala.collection.mutable.ListBuffer
trait StockDao
{
  def addItemtoStock(stock:Stock):Unit
  def removeItems(stock: Stock): Unit
  def getStock():ListBuffer[Stock]
}
