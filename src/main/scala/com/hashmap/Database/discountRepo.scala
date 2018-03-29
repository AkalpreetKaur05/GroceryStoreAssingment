package com.hashmap.Database
import model.Item

import scala.collection.mutable
object discountRepo
{
 val itemperdiscount=mutable.Map[(Int,Int),Double]()
  val itembuydiscount=mutable.Map[Item,Double]()
}
