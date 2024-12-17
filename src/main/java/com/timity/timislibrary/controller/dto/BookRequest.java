package com.timity.timislibrary.controller.dto;

import com.timity.timislibrary.service.model.book.Book;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotNull
    private Book book;
}
