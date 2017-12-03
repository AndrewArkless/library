package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import models.DVDS
import play.api.mvc.{Action, Controller}
import services.DVDsService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class AllDVDsController @Inject()(ds:DVDsService) extends Controller {
  def present()=Action.async {
    implicit request =>
      val allDVDS: Future[DVDS] = ds.getAllDVDs
      allDVDS.map { dvds =>
        Ok(views.html.alldvds(dvds.dvds))
      }
  }
}
