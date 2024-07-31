package co.com.book.model;

import lombok.Data;

@Data
public class Book {

    private Long id;
    private String bookName;
    private String releaseYear;
    private String author;
}
