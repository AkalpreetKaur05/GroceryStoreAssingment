package dao
import com.hashmap.dao.StockDaoimplementation
import com.hashmap.model.Stock
import model.Item

import scala.collection.mutable.ListBuffer
object CatalogRepo
{
 //val itemmap=mutable.Map[Int,Item]()
// val itemStock=mutable.Map[Int,Int]()
 val itemaddinStock=new StockDaoimplementation
 val listItems=new ListBuffer[Item]()
 def addItemsRepo(stock:Stock): Unit =
  {
   itemaddinStock.addItemtoStock(stock)
   //listStock+=stock
   listItems+=stock.Item
   // itemStock+=(item.id->item.quantity)
   // println(itemmap)
  }
  def getItemRepo():ListBuffer[Item]=
  {
   listItems
   //itemmap.values.toList
  }
/* def getItemStock():ListBuffer[Stock] =
  {
   return listStock
  }*/
 /*def removefromStock(stock: Stock): Unit =
 {
  listStock-=stock
 }*/

}
