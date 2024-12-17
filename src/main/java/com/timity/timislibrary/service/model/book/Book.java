package com.timity.timislibrary.service.model.book;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String description;
    private BookType bookType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(description, book.description) && bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, description, bookType);
    }
}
