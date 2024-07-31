package co.com.book.usecase;

import co.com.book.model.Book;
import co.com.book.model.gateways.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookUseCase {

    private final BookRepository bookRepository;

    public Book getBook (Long id){
        return bookRepository.getBook(id);
    }

    public Book saveBook (Book book){
        return bookRepository.saveBook(book);
    }
    public Book updateBook (Book book){
        return bookRepository.updateBook(book);
    }
    public  void deleteBook (Long id){
        bookRepository.deleteBook(id);
    }
}
