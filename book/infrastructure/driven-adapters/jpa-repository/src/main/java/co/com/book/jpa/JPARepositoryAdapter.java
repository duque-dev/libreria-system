package co.com.book.jpa;

import co.com.book.jpa.helper.AdapterOperations;
import co.com.book.model.Book;
import co.com.book.model.gateways.BookRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Book, BookEntity, Long, JPARepository>
implements BookRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /*
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Book.class));
    }

    @Override
    public Book getBook(Long id) {
        return this.toEntity(this.repository.findById((id)).orElse(new BookEntity()));
    }

    @Override
    public Book saveBook(Book book) {
        return this.toEntity(this.repository.save(toData(book)));
    }

    @Override
    public Book updateBook(Book book) {
        return this.toEntity(this.repository.save(toData(book)));
    }

    @Override
    public void deleteBook(Long id) {
        this.repository.deleteById((id));
    }
}
