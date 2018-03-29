package com.hashmap.Database
import com.hashmap.model.Stock
import scala.collection.mutable.ListBuffer
object StockRepo
{
  val listStock=new ListBuffer[Stock]()
  def addItem(stock:Stock): Unit =
  {
    listStock+=stock
  }
  def removefromStock(stock: Stock): Unit =
  {
    listStock-=stock
  }
  def getItemStock():ListBuffer[Stock] =
  {
    return listStock
  }
}
