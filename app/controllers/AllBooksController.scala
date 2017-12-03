package controllers

import javax.inject.Singleton

import com.google.inject.Inject
import models.Books
import play.api.mvc.{Action, Controller}
import services.BooksService
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

/**
  * Created by andrew on 28/11/17.
  */
@Singleton
class AllBooksController @Inject()(bs:BooksService) extends Controller{
 def present=Action.async{ implicit request =>
   val allBooks: Future[Books] =bs.getAllBooks
   allBooks.map{books =>
     Ok(views.html.allBooks(books.books))
   }
 }
}
