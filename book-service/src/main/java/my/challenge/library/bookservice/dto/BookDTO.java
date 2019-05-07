package my.challenge.library.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String id;
    private String title;
    private String description;
    private String style;
    private String authorId;
}
