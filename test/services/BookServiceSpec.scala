package services

import connectors.BackEndConnectors
import models.{Book, Books}
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import scala.concurrent.Future
import ScalaFutures._

class BookServiceSpec extends PlaySpec with GuiceOneAppPerTest {
  val response=Future.successful(Books(List[Book](Book("It","Stephen King"),Book("The Cyberiad","Stanislaw Lem"))))
  object FakeConnector extends BackEndConnectors{
    override def getBooks =response
    override def getDVDS = ???
  }
  "Calling getAllBooks" should {
    "return list of Books" in {
      val allBooks = new RealBooksService(FakeConnector)
      whenReady(allBooks.getAllBooks){r =>
        r mustBe Books(List[Book](Book("It","Stephen King"),Book("The Cyberiad","Stanislaw Lem")))
      }
    }
  }
}
