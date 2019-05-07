package my.challenge.library.bookservice.service;

import my.challenge.library.bookservice.entity.Book;

import java.util.Optional;

public interface BookService {

    Book create(Book book);

    Optional<Book> findById(Long id);
}
