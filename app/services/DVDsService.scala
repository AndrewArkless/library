package services

import com.google.inject.{ImplementedBy, Inject}
import connectors.BackEndConnectors
import models.{DVD, DVDS}

import scala.concurrent.Future

/**
  * Created by andrew on 29/11/17.
  */
class RealDVDsService @Inject()(cn:BackEndConnectors) extends DVDsService{
  override def getAllDVDs=cn.getDVDS
}

@ImplementedBy(classOf[RealDVDsService])
trait DVDsService {
  def getAllDVDs:Future[DVDS]
}
