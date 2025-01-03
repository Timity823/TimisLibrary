package com.timity.timislibrary.controller.dto;

import com.timity.timislibrary.service.model.libraryuser.LibraryUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUserRequest {
    @NotNull
    private LibraryUser libraryUser;
}
