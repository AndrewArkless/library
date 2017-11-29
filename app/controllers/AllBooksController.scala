package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.BooksService

/**
  * Created by andrew on 28/11/17.
  */
@Singleton
class AllBooksController @Inject()(bs:BooksService) extends Controller{
 def present=Action{ implicit request =>
   val allBooks=bs.getAllBooks
   Ok(views.html.allBooks(allBooks))
 }
}
