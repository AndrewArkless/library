package services

import com.google.inject.ImplementedBy
import models.DVD

/**
  * Created by andrew on 29/11/17.
  */
class RealDVDsService extends DVDsService{
  override def getAllDVDs=List[DVD](DVD("The Thing","John Carpenter"),DVD("Alien","Ridley Scott"))}

@ImplementedBy(classOf[RealDVDsService])
trait DVDsService {
  def getAllDVDs:List[DVD]
}
