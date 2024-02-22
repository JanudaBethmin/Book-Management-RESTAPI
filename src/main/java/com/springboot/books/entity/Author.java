package com.springboot.books.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //  Lets you automatically produce the code required to have your class be instantiable with code
@Entity // Labels as an object that can be used by Spring Data JPA.
@Table(name = "authors") // Saying which table this entity maps to in the database
public class Author {

    @Id
    // When we create a DB it will create an ID that will be incremented by 1 every time.
    // This only generates IDs when we don't provide ones by our selves.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id; // We don't use long because it defaults to 0. Long defaults to null.
    private String name;
    private Integer age; // We don't use int because it defaults to 0. Integer defaults to null.

}
