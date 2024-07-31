package co.com.book.api;
import co.com.book.model.Book;
import co.com.book.usecase.BookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final BookUseCase bookUseCase;
//    private final MyUseCase useCase;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long  id) {
//      return useCase.doAction();
        return ResponseEntity.ok(bookUseCase.getBook(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookUseCase.saveBook(book));
    }
    @PutMapping(path = "/")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookUseCase.updateBook(book));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long  id) {
        bookUseCase.deleteBook(id);
        return ResponseEntity.ok("Libro eliminado exitosamente");
    }


}
