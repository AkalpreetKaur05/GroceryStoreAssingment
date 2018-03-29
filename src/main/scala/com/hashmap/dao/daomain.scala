package dao
import com.hashmap.model.Stock
import model.Item

import scala.collection.mutable.ListBuffer
trait daomain
{
  def addItems(stock:Stock)
  //def removeItems(stock: Stock)
//  def addItemstocart(cart:Cart)
  def getItems():ListBuffer[Item]
}
