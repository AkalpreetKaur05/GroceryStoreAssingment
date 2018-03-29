package ModelTest
import model.Item
import org.scalatest.FunSuite

import scala.xml.XML
class ItemTest extends FunSuite
{
  test("Item present or not")
  {
    val read= XML.loadFile("src/main/scala/com/hashmap/resources/store.xml")

  }
  test("Item in item") {
    val id=100
    assert(id.equals(Item(100,"Dove Soap",50.0).id))
  }
}
