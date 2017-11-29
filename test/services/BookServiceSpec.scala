package services

import models.Book
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}

/**
  * Created by andrew on 29/11/17.
  */
class BookServiceSpec extends PlaySpec with OneAppPerTest {

  val listOfBooks=List[Book](Book("It","Stephen King"),Book("The Cyberiad","Stanislaw Lem"))
  "Calling getAllBooks" should {
    "return list of Books" in {
      val allBooks = new RealBooksService
      allBooks.getAllBooks mustBe listOfBooks
    }
  }
}
