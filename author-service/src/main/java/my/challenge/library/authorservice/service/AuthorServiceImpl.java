package my.challenge.library.authorservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import my.challenge.library.authorservice.entity.Author;
import my.challenge.library.authorservice.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
