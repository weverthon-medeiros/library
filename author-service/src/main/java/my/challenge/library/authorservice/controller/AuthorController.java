package my.challenge.library.authorservice.controller;

import my.challenge.library.authorservice.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import my.challenge.library.authorservice.dto.AuthorDTO;
import my.challenge.library.authorservice.entity.Author;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthorController {
    
    private AuthorService authorService;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/authors/{id}")
    public AuthorDTO getAuthor(@PathVariable Long id) {
        return authorService.findById(id).map(this::convertToDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found. id: "+id));
    }

    @PostMapping("/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return convertToDTO(authorService.create(convertFromDTO(authorDTO)));
    }
    
    private AuthorDTO convertToDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    private Author convertFromDTO(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }
}
