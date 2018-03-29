package ServicesTest
import Services.{CatalogServices, XmlServices}
import com.hashmap.Services.CartServices
import com.hashmap.dao.{CartDaoImplemenation, StockDaoimplementation, daoimplementation}
import com.hashmap.model.Cart
import model.Item
import org.junit.Before
import org.scalatest.FunSuite
import scala.collection.mutable

class CartServicesTest extends FunSuite
{
  @Before
  val obj1 = new daoimplementation
  val obj2 = new XmlServices
  val obj3=new StockDaoimplementation
  val obj = new CatalogServices(obj2, obj1,obj3)
  val cartService = new CartServices(new CartDaoImplemenation,obj,new Cart)
  obj.buildCatalog("src/test/scala/TestCases/resources/store.xml")

  test("To check items are added to cart")
  {
    cartService.addItemsToCart(101,3)
   // var size=cartService.showCartItems().size
    assert(cartService.showCartItems().size==1)
  }
  test("to check if items are removed")
  {
    cartService.addItemsToCart(101,2)
    cartService.addItemsToCart(100,3)
    cartService.removeFromCart(101,1)
    assert(cartService.showCartItems().size==2)
  }
  test("to check if quantity of Items are updated")
  {
    cartService.addItemsToCart(101,3)
    cartService.removeFromCart(101,1)
    val itemMap=mutable.Map(Item(101,"Dove soap",30.0)->2,Item(100,"LUX bath soap",12.0)->3)
    assert(cartService.showCartItems().equals(itemMap))
  }
  /*test("if item is present in catalog or not")
  {
    val value=cartService.IsitemPresentInCatalog(Item(101,"Dove soap",30.0))
    assert(value==true)
  }*/

}
