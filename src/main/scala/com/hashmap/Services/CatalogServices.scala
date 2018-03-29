package Services
import java.io.FileNotFoundException

import com.hashmap.Exceptions.{CatalogEmptyException, StockEmptyException}
import com.hashmap.dao.{StockDaoimplementation, daoimplementation}
import com.hashmap.model.{Catalog, Stock}
import model.Item

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
 class CatalogServices(xmlServices: XmlServices,daoimp:daoimplementation,stockdao: StockDaoimplementation)
{
  @throws(classOf[FileNotFoundException])
  def buildCatalog(path:String): Unit =
  {try {
    val itemReadCatalog = xmlServices.readFromXml(path)
      for (itemnew <- itemReadCatalog) {
        addToCatalog(itemnew)
         //Catalog.setlistValues(itemnew)
      }
  }
    catch {
        case ex:FileNotFoundException=>println("file not found")
      }
  }
  def getCatalogItems:Either[Throwable,ListBuffer[Item]]  = {
      Catalog.setlistValues(daoimp.getItems())
      try{Right(daoimp.getItems())}
      catch {case e=>Left(throw new CatalogEmptyException("no Item present in catalog")) }


    }

  def addToCatalog(stock:Stock): Unit =
  {
    Catalog.setlistValues(daoimp.getItems())
    daoimp.addItems(stock)
  }

  def removeCatalogItem(stock: Stock): Unit =
  {
     stockdao.removeItems(stock)//daoimp.removeItems(stock)
  }

  def getCatalogItemsStock():Either[Throwable,ListBuffer[Stock]]  =
  {try {Right(stockdao.getStock())}
    catch{case e=>Left(throw new StockEmptyException("Stock is empty"))}

  }
 def updateStock(itemMap:mutable.Map[Item,Int]):Unit= {
   var abc = getCatalogItemsStock()
   var abc1=abc match{case Right(abc)=>abc}
   //println("itemss ssssss "+abc)
   for (i <- itemMap.keys) {
     val itemStock = checkStocks(abc1, i)
     if (itemStock == None) {}
     else {
       val valueItem = itemMap.get(i)
       val valueItem1 = valueItem match {
         case Some(x) => x
         case None => 0
       }
       val newUpdatedStock = updateStockForItems(itemStock.get, valueItem1)
      // println("stock updated is "+newUpdatedStock)
       // obj.removeCatalogItem()
       addToCatalog(newUpdatedStock)
     }
   }
 }
    def checkStocks(stockOld: ListBuffer[Stock], item: Item):Option[Stock]=
    {
      (stockOld.find(x=>x.Item==(item)))
    }
  def updateStockForItems(oldstock:Stock, quantity:Int):Stock=
  {
    val quantity1=oldstock.quantity-quantity
    removeCatalogItem(oldstock)
    oldstock.copy(quantity=quantity1)
  }

}


