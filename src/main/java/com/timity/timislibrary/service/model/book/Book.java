package com.timity.timislibrary.service.model.book;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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

    private Integer id;
    @NotBlank
    @Min(2)
    private String title;
    @NotBlank
    private String author;
    @NotNull
    private String description;
    @NotNull
    private BookType bookType;

}
