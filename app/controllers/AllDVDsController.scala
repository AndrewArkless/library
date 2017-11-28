package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}


@Singleton
class AllDVDsController @Inject() extends Controller {
  def present()=Action{
    implicit request =>
    Ok(views.html.alldvds())
  }

}
