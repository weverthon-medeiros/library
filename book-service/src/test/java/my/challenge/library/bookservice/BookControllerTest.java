package my.challenge.library.bookservice;

import my.challenge.library.bookservice.controller.BookController;
import my.challenge.library.bookservice.entity.Book;
import my.challenge.library.bookservice.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void givenBook_whenGetBook_thenReturnJsonObject() throws Exception {
        Book book1 = new Book(1L, "Book 1", "Description 1", "Test", 3L);

        given(bookService.findById(1L)).willReturn(Optional.of(book1));

        mvc.perform(get("/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(String.valueOf(book1.getId()))))
                .andExpect(jsonPath("$.title", is(book1.getTitle())))
                .andExpect(jsonPath("$.description", is(book1.getDescription())))
                .andExpect(jsonPath("$.style", is(book1.getStyle())))
                .andExpect(jsonPath("$.authorId", is(String.valueOf(book1.getAuthorId()))));
    }

    @Test
    public void givenGetBook_whenBookDoesNotExist_thenReturnError() throws Exception {
        mvc.perform(get("/books/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}
