package controllers

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test._
import play.api.test.Helpers._
/**
  * Created by andrew on 28/11/17.
  */
class AllBooksSpec extends PlaySpec with OneAppPerTest {

  "AllBooks Controller" should {
    "render the page and display All Books" in {
      val controller=new AllBooksController
      val allBooks=controller.present().apply(FakeRequest())
      status(allBooks) mustBe OK
      contentType(allBooks) mustBe Some("text/html")
      contentAsString(allBooks) must include ("All your Books!")
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
