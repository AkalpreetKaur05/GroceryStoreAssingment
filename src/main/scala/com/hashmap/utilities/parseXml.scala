package com.hashmap.utilities
import com.hashmap.model.Stock
import model.Item

import scala.xml.Node
object parseXml {
  def readXml(node: Node):  Stock = {

      val itemId = (node \\ "id").text.toInt
      val itemName = (node \\ "name").text
      val itemPrice = (node \\ "unitPrice" \ "amount").text.toDouble
      val itemquantity = (node \\ "quantity" \ "stock").text.toInt
      //println("item id is "+itemId+"itemname is "+itemName+" item price is  "+itemPrice)
      Stock(Item(itemId, itemName, itemPrice), itemquantity)
  }
}