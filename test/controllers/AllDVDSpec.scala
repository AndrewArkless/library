package controllers

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by andrew on 28/11/17.
  */
class AllDVDSpec extends PlaySpec with OneAppPerTest{

  "Calling DVDController" should {
    "Return page displaying All DVDS" in {
      val controller = new AllDVDsController
      val result=controller.present.apply(FakeRequest())
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("All your DVDS!")
    }
  }

  "Calling allDVDS url" should {
    "Return page displaying All DVDS" in {
      val request=FakeRequest(GET,"/all-dvds").withHeaders("host"->"localhost")
      val result=route(app,request).get
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("All your DVDS!")
    }
  }

}
