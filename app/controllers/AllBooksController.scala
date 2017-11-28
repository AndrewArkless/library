package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}

/**
  * Created by andrew on 28/11/17.
  */
@Singleton
class AllBooksController @Inject() extends Controller{
 def present=Action{ implicit request =>
   Ok(views.html.allBooks())
 }
}
