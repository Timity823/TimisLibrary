package com.timity.timislibrary.repository.entity;

import com.timity.timislibrary.service.model.book.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer id;
    private String title;
    private String author;
    @Column(name = "book_type")
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    private String description;
}
