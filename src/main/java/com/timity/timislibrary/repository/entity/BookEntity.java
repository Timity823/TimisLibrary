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
    @Column(name = "id")
    private Integer id;
    private String title;
    private String author;
    private BookType bookType;
}
