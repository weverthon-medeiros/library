package my.challenge.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import my.challenge.library.entity.Author;
import my.challenge.library.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    
    @Override
    public List<Author> listAll() {
        return null;
    }

    @Override
    public List<Author> findByName() {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author create() {
        return null;
    }
}