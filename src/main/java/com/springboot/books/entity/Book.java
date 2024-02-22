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
@Entity
@Table(name = "books")
public class Book {

    @Id
    // We make a design decision to provide the isbn every time we create a book, we are not going to generate that.
    private String isbn;
    private String title;

    // Telling Spring what type of relationship there is between those objects
    // Cascade -> When we retrieve an author object from a book, if we do any changes they will be reported to the authors table in the database.
    // So there won't be any conflicts.
    @ManyToOne(cascade = CascadeType.ALL)
    // Telling Spring to use author_id column inorder to join authors and books tables.
    @JoinColumn(name = "author_id")
    private Author author;

}
