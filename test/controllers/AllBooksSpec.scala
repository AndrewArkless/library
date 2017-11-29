package controllers

import models.Book
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.BooksService
/**
  * Created by andrew on 28/11/17.
  */
class AllBooksSpec extends PlaySpec with GuiceOneAppPerTest with MockitoSugar{

  object fakeBookServiceNoBooks extends BooksService{
    override def getAllBooks=List[Book]()
  }

  object fakeBookServiceSomeBooks extends BooksService{
    override def getAllBooks=List[Book](
      Book("Picnic at Hanging Rock","Joan Lindsay"),
      Book("Poland a History","Adam Zamoyski")
    )
  }
  "AllBooks Controller" should {
    "render the page and display All Books" in {
      val controller=new AllBooksController(fakeBookServiceSomeBooks)
      val allBooks=controller.present().apply(FakeRequest())
      status(allBooks) mustBe OK
      contentType(allBooks) mustBe Some("text/html")
      contentAsString(allBooks) must include ("All your Books!")
      contentAsString(allBooks) must include ("Picnic at Hanging Rock")
      contentAsString(allBooks) must include ("Joan Lindsay")
      contentAsString(allBooks) must include ("Poland a History")
      contentAsString(allBooks) must include ("Adam Zamoyski")
    }

    "render the page and display No Books" in {
      val controller=new AllBooksController(fakeBookServiceNoBooks)
      val allBooks=controller.present().apply(FakeRequest())
      status(allBooks) mustBe OK
      contentType(allBooks) mustBe Some("text/html")
      contentAsString(allBooks) must include ("All your Books!")
      contentAsString(allBooks) must not include ("Picnic at Hanging Rock")
    }
  }

  "AllBooks URl" should {
    "render the page and display All Books" in {
      val request=FakeRequest(GET,"/all-books").withHeaders("host"->"localhost")
      val result=route(app,request).get
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("All your Books!")
    }
  }
}
