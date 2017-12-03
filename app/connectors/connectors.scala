package connectors

import com.google.inject.ImplementedBy
import models.{Books, DVDS}
import org.apache.http.protocol.HTTP

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import uk.gov.hmrc.play.http.{HeaderCarrier, HttpReads, HttpResponse}
import uk.gov.hmrc.play.http.ws.WSGet
/**
  * Created by andrew on 02/12/17.
  */

class BackEndConnectorImp extends BackEndConnectors {
  val http = new WSGet {
    override val hooks = NoneRequired
  }

  class JsonValidationException(message: String) extends Exception(message)

  def getBooks: Future[Books] = {
    implicit val hc = HeaderCarrier()
    val response: Future[HttpResponse] = http.GET[HttpResponse]("http://localhost:9001/get-all-books")(rds = HttpReads.readRaw, hc)
      response.flatMap { httpResponse =>
      httpResponse.json.validate[Books].fold(
        invalid => Future.failed(new JsonValidationException("invalid")),
        valid => Future.successful(valid)
      )
    }
  }
  def getDVDS:Future[DVDS]={
    implicit val hc=HeaderCarrier()
    val response=http.GET[HttpResponse]("http://localhost:9001/get-all-dvds")(rds=HttpReads.readRaw,hc)
    response.flatMap{httpResponse=>
      println(httpResponse.json)
      httpResponse.json.validate[DVDS].fold(
        invalid=>Future.failed(new JsonValidationException("invalid")),
        valid=>Future.successful(valid)
      )
    }
  }
}

@ImplementedBy(classOf[BackEndConnectorImp])
trait BackEndConnectors {
  def getBooks:Future[Books]
  def getDVDS:Future[DVDS]
}