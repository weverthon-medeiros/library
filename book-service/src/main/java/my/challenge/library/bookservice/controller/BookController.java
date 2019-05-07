package my.challenge.library.bookservice.controller;

import my.challenge.library.bookservice.dto.BookDTO;
import my.challenge.library.bookservice.entity.Book;
import my.challenge.library.bookservice.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BookController {
    private BookService bookService;
    private ModelMapper mapper;

    @Autowired
    public BookController(BookService bookService, ModelMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @GetMapping("/books/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.findById(id).map(this::convertToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found. id:" + id));
    }

    @PostMapping("books")
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        return convertToDTO(bookService.create(convertFromDTO(bookDTO)));
    }

    private BookDTO convertToDTO(Book book) {
        return mapper.map(book, BookDTO.class);
    }

    private Book convertFromDTO(BookDTO bookDTO) {
        return mapper.map(bookDTO, Book.class);
    }
}
