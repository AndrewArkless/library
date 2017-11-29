package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.DVDsService


@Singleton
class AllDVDsController @Inject()(ds:DVDsService) extends Controller {
  def present()=Action{
    implicit request =>
      val allDVDS=ds.getAllDVDs
    Ok(views.html.alldvds(allDVDS))
  }

}
