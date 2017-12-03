package models

import play.api.libs.json.{Format, Json}

/**
  * Created by andrew on 29/11/17.
  */
case class Book(title:String,author:String)

object Book{
  implicit val formats:Format[Book] =Json.format[Book]
}

case class Books(books:List[Book])

object Books{
  implicit val formats:Format[Books]=Json.format[Books]
}

case class DVD(title:String,director:String)

object DVD{
  implicit val formats:Format[DVD]=Json.format[DVD]
}

case class DVDS(dvds:List[DVD])

object DVDS {
  implicit val formats:Format[DVDS]=Json.format[DVDS]
}