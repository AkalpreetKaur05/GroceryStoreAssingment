package com.hashmap.Services

import java.util.TimerTask

import Services.{CatalogServices, XmlServices}
import com.hashmap.dao.{StockDaoimplementation, daoimplementation}
import com.hashmap.model.Stock

import scala.collection.mutable.ListBuffer
class Scheduler(newFilepath:String,oldFilepath:String) extends TimerTask {
  val obj = new CatalogServices(new XmlServices, new daoimplementation,new StockDaoimplementation)
  run()

  def run(): Unit = {
    val file = newFilepath//"src/main/scala/com/hashmap/resources/storenew.xml"
    val newStock = (new XmlServices).readFromXml(file)
    obj.buildCatalog(oldFilepath)//"src/main/scala/com/hashmap/resources/store.xml")
    val oldStock = obj.getCatalogItemsStock()
    val oldStockNew=oldStock match{case Right(oldStock)=>oldStock}
    updateStock(oldStockNew.toList, newStock)
  }

  def updateStock(oldStock: List[Stock], newStock: List[Stock]): ListBuffer[Stock] = {
    for (st <- newStock) {
      val itemStock = checkStocks(oldStock, st)
      if (itemStock == None) {obj.addToCatalog(st)}
      else {
        val newUpdatedStock = updateStockforItems(st, itemStock.get)
       // obj.removeCatalogItem()
        obj.addToCatalog(newUpdatedStock)
      }

    }
    val newItemStock = obj.getCatalogItemsStock() match {case Right(x)=>x}
    println("new itwms are")
    newItemStock.foreach(println)
    newItemStock
  }

  def checkStocks(old:List[Stock],st:Stock): Option[Stock] =
  {
    (old.find(x=>x.Item.id==(st.Item.id)))
  }
  def updateStockforItems(newstock: Stock, oldstock: Stock):Stock=
  {
    val quantity=newstock.quantity+oldstock.quantity
    obj.removeCatalogItem(oldstock)
    oldstock.copy(quantity=quantity)

  }

}
