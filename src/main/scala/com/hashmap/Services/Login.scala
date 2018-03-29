package Services
import com.hashmap.Services.CartServices
import com.hashmap.dao.{CartDaoImplemenation, StockDaoimplementation, daoimplementation}
import com.hashmap.model.Cart
object Login extends App
{
  /*val itemReadCatalog=new XmlServices().readFromXml()
  val daoimp=new daoimplementation
  val obj=new CatalogServices(new XmlServices(),daoimp)
  //val itemsInCatalog=obj.getCatalogItems()
  BuildCatalog(itemReadCatalog)
  def BuildCatalog( itemPresent:List[Stock]): Unit =
   {
     for(newitems<-itemPresent)
       {
         obj.addToCatalog(newitems)
       }
     val Items=obj.getCatalogItems
     for(i<-0 to Items.length-1)
       {
         println(Items(i))
       }
    // println(Items.length)
    }
    */
  val daoimp=new daoimplementation
  val stockDao=new StockDaoimplementation
  val obj=new CatalogServices(new XmlServices(),daoimp,stockDao)
  obj.buildCatalog("src/main/scala/com/hashmap/resources/store.xml")
  val itemsInCatalog=obj.getCatalogItems
  println("Items in catalog are")
     itemsInCatalog.foreach(println)
//  val itemsinstock=obj.getCatalogItemsStock()
  //itemsinstock.foreach(println)
 val cartdao=new CartDaoImplemenation
  val abc=new Cart
  val cartservice=new CartServices(cartdao,obj,abc)
     val cart=cartservice.addItemsToCart(100,3)
  cartservice.addItemsToCart(101,3)
     val cartget=cartservice.showCartItems()
     println("iiiii"+cartget)

 val bill= cartservice.CalculateBill()
  println(bill)
  //val cartget1=cartservice.removeFromCart(101,1)
   //  val cartget2=cartservice.showCartItems()
     //println("itemmmmmm are"+cartget2)
    // println(cartservice.showCartItems())
  println("bill of individual item is"+cartservice.CalculateBill())
  val totalBill=cartservice.generateOrderSummary
  println("bill is "+totalBill)
 /* val abc=obj.getCatalogItemsStock()
  println("Items in stock are"+abc)
  abc.foreach(println)*/
}
