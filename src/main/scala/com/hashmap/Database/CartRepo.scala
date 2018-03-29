package com.hashmap.Database

import model.Item

import scala.collection.mutable

object CartRepo   
{
  val itemBought=mutable.Map[Item,Int]()
  val billCalIndividualItem=mutable.Map[(Item,Int),Double]()
  var bill:Double=0
}
