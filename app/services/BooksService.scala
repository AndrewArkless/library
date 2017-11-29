package services

import com.google.inject.ImplementedBy
import models.Book

class RealBooksService extends BooksService{
  def getAllBooks=List[Book](Book("It","Stephen King"),
                             Book("The Cyberiad","Stanislaw Lem")
  )
}
@ImplementedBy(classOf[RealBooksService])
trait BooksService {
  def getAllBooks: List[Book]
}
