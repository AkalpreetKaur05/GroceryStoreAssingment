package Services
import com.hashmap.Exceptions.FileEmptyException
import com.hashmap.model.Stock
import com.hashmap.utilities.parseXml

import scala.xml.XML
 class XmlServices
{
  @throws(classOf[FileEmptyException])
  def readFromXml(filepath:String):List[Stock] =
  {
    //checkFileEmpty("")
    val file=XML.loadFile(filepath)
    val item1=(file \\ "item").map(parseXml.readXml).toList
    item1
  }
  def checkFileEmpty(file:String):Either[Throwable,String]=
  {
    if(file.isEmpty) {
      Left(throw new FileEmptyException("File is empty"))
      }
    else {
      Right(file)
      }

  }



}
