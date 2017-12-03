package services

import connectors.BackEndConnectors
import models.{DVD, DVDS}
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by andrew on 29/11/17.
  */
class DVDServiceSpec extends PlaySpec with GuiceOneAppPerTest with ScalaFutures {

  val listOfDvds=Future(DVDS(List[DVD](DVD("The Thing","John Carpenter"),DVD("Alien","Ridley Scott"))))
  object fakeBackEndConnector extends BackEndConnectors{
    def getDVDS=listOfDvds
    def getBooks = ???
  }
  "Calling DVD Service all DVDS" should {
    "return a List of) DVDS" in {
      val allDvds = new RealDVDsService(fakeBackEndConnector)
        whenReady(allDvds.getAllDVDs){ r =>
        r mustBe DVDS(List[DVD](DVD("The Thing","John Carpenter"),DVD("Alien","Ridley Scott")))
      }
    }
  }
}
