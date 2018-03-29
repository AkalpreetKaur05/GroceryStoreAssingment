package com.hashmap.dao
import com.hashmap.Database.StockRepo
import com.hashmap.model.Stock
import scala.collection.mutable.ListBuffer
class StockDaoimplementation extends StockDao
{
  override def addItemtoStock(stock: Stock): Unit =
  {
    StockRepo.addItem(stock)
  }
  def removeItems(stock: Stock): Unit =
  {
    StockRepo.removefromStock(stock)
  }
  def getStock():ListBuffer[Stock]=
  {
    StockRepo.getItemStock()
  }

}
