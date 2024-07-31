package co.com.book.model.gateways;

import co.com.book.model.Book;

public interface BookRepository {
    Book getBook(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);

}
