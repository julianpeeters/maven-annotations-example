package com.jp

import com.julianpeeters.avro.annotations._

// Methods that serialize/deserialize avro records to/from File/Stream
// Uses macro-annotations that create necessary case-classes from schema
// ----------
@AvroTypeProvider("src/main/scala/SkuRecord.avsc")
@AvroRecord
case class SkuRecord()

object AvroCaseClasses {
  def main( args: Array[String]):Unit = {

    val sr = SkuRecord( "sku", 10, List(2,10), "typea", "branda", "desca", 
        List("item1", "item2" ))
    println( sr )
  }
}


