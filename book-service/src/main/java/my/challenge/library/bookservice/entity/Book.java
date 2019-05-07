package my.challenge.library.bookservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Size(max = 200)
    private String title;

    @Column
    private String description;

    @Column
    private String style;

    @Column(nullable = false)
    private Long authorId;
}
