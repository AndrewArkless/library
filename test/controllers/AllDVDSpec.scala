package controllers

import models.{DVD, DVDS}
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.DVDsService
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by andrew on 28/11/17.
  */
class AllDVDSpec extends PlaySpec with GuiceOneAppPerTest{

  object fakeDVDServiceNoDVDS extends DVDsService{
    override def getAllDVDs = Future(DVDS(List[DVD]()))
  }

  object fakeDVDServiceAllDVDS extends  DVDsService{
    override def getAllDVDs=Future(DVDS(List[DVD](DVD("Star Wars","George Lucas"),DVD("SUPER 8","JJ ABRAMS"))))
  }
//  "Calling allDVDS url" should {
//      "Return page displaying All DVDS" in {
//        val request = FakeRequest(GET, "/all-dvds").withHeaders("host" -> "localhost")
//        val result = route(app, request).get
//        status(result) mustBe OK
//        contentType(result) mustBe Some("text/html")
//        contentAsString(result) must include("All your DVDS!")
//      }
//    }
  "Calling DVDController" should {
    "Return page displaying no DVDS" in {
      val controller = new AllDVDsController(fakeDVDServiceNoDVDS)
      val result = controller.present.apply(FakeRequest())
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("All your DVDS!")
      contentAsString(result) must not include ("Star Wars")
    }


    "Calling DVDController" should {
      "Return page displaying All DVDS" in {
        val controller = new AllDVDsController(fakeDVDServiceAllDVDS)
        val result = controller.present.apply(FakeRequest())
        status(result) mustBe OK
        contentType(result) mustBe Some("text/html")
        contentAsString(result) must include("Star Wars")
        contentAsString(result) must include("George Lucas")
        contentAsString(result) must include("SUPER 8")
        contentAsString(result) must include("JJ ABRAMS")
        contentAsString(result) must include("All your DVDS!")
      }
    }

////    "Calling allDVDS url" should {
//      "Return page displaying All DVDS" in {
//        val request = FakeRequest(GET, "/all-dvds").withHeaders("host" -> "localhost")
//        val result = route(app, request).get
//        status(result) mustBe OK
//        contentType(result) mustBe Some("text/html")
//        contentAsString(result) must include("All your DVDS!")
//      }
//    }
  }
}
