package TestCases
import Services._
import com.hashmap.dao.{StockDaoimplementation, daoimplementation}
import org.junit.Before
import org.scalatest.FunSuite

class CatalogServicesTest extends FunSuite
{
  @Before
  val obj1=new daoimplementation
  val obj2=new XmlServices
  val obj3=new StockDaoimplementation
  val obj=new CatalogServices(obj2,obj1,obj3)
  val path="src/test/scala/TestCases/resources/store.xml"
  obj.buildCatalog(path)

  test("testing items are present in catalog") {
   val itemsincatalog = obj.getCatalogItems
   assert(itemsincatalog.isRight)
 }
  test("to build a catalog")
  {
    //obj.buildCatalog(path)
    assert(!path.isEmpty)
  }
  test("Stock of Items is empty")
  {
    val stockItems=obj.getCatalogItemsStock()
    assert(stockItems.isRight)
  }
}
