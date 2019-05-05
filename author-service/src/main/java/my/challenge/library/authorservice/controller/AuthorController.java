package my.challenge.library.authorservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import my.challenge.library.authorservice.dto.AuthorDTO;
import my.challenge.library.authorservice.entity.Author;
import my.challenge.library.authorservice.service.AuthorService;

@RestController
public class AuthorController {
    
    private AuthorService authorService;
    private ModelMapper modelMapper;
    
    public AuthorController(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/authors/{id}")
    public AuthorDTO getUser(@PathVariable Long id) {
        return authorService.findById(id).map(this::convertToDTO)
            .orElseThrow(() -> new RuntimeException("Author not found. id: "+id));
            
    }
    
    private AuthorDTO convertToDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }
}
