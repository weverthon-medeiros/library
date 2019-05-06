package my.challenge.library.authorservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.challenge.library.authorservice.controller.AuthorController;
import my.challenge.library.authorservice.entity.Author;
import my.challenge.library.authorservice.service.AuthorService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService service;

    @Test
    public void givenAuthor_whenGetAuthor_thenReturnJsonObject() throws Exception {
        Author mark = new Author(1L, "Mark");

        given(service.findById(mark.getId())).willReturn(Optional.of(mark));

        mvc.perform(get("/authors/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(String.valueOf(mark.getId()))))
                .andExpect(jsonPath("$.name", is(mark.getName())));
    }

    @Test
    public void givenGetAuthor_whenAuthorDoesNotExist_thenReturnError() throws Exception {


        mvc.perform(get("/authors/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
//                .andExpect(jsonPath("$.message", is("Author not found. id: 99")));

    }

    @Test
    public void givenAuthorDTO_whenSaveAuthor_thenReturnJsonObject() throws Exception {
        Author paul = new Author(2L, "Paul");

        given(service.create(paul)).willReturn(paul);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        mvc.perform(post("/authors")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsBytes(paul)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(String.valueOf(paul.getId()))))
                .andExpect(jsonPath("$.name", is(paul.getName())));
    }
}
