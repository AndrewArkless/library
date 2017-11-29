package services

import models.DVD
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest

/**
  * Created by andrew on 29/11/17.
  */
class DVDServiceSpec extends PlaySpec with GuiceOneAppPerTest {
  val listOfDvds=List[DVD](DVD("The Thing","John Carpenter"),DVD("Alien","Ridley Scott"))
  "Calling DVD Service all DVDS" should {
    "return a List of DVDS" in {
      val allDvds=new RealDVDsService
      allDvds.getAllDVDs mustBe listOfDvds
    }
  }
}
