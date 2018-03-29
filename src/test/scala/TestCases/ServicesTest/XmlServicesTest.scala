package TestCases

import Services.XmlServices
import org.junit.Before
import org.scalatest.FunSuite

import scala.xml.XML

class XmlServicesTest extends FunSuite
{
  @Before
 val file="src/test/scala/TestCases/resources/store.xml"
  test("Read from xml")
  {
    // assert(XML.loadFile("src/main/scala/com/hashmap/resources/store.xml").nonEmpty)
    assert(XML.loadFile("src/test/scala/TestCases/resources/store.xml").nonEmpty)
    //val item1=(read \\ "item").map(ItemOrder.readXml).toList
    //assert(item1.nonEmpty)
  }

  test("to check xml parsing")
  {
    val read=new XmlServices().readFromXml(file)
    assert(!read.isEmpty)
  }

}
