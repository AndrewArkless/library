package services

import com.google.inject.{ImplementedBy, Inject}
import connectors.BackEndConnectors
import models.{Book, Books}

import scala.concurrent.Future
class RealBooksService @Inject()(cn:BackEndConnectors) extends BooksService{
  def getAllBooks: Future[Books] = {
    cn.getBooks
  }
}

@ImplementedBy(classOf[RealBooksService])
trait BooksService {
  def getAllBooks: Future[Books]
}
