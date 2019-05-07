package my.challenge.library.bookservice.controller;

import my.challenge.library.bookservice.entity.Book;
import my.challenge.library.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Book not found. id:" + id));
    }

    @PostMapping("books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.create(book);
    }
}
