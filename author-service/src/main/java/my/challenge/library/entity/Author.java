package my.challenge.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String name;
    
    public Author(String name) {
        this.name = name;
    }
}
