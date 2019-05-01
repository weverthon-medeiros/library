package my.challenge.library.service;

import my.challenge.library.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();
    List<Author> findByName();
    Optional<Author> findById(Long id);
    Author create();
}
