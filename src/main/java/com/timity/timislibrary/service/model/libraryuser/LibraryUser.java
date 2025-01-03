package com.timity.timislibrary.service.model.libraryuser;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUser {
    private Integer libraryUser_id;
    @NotBlank
    private String name;
    private String email;
    @NotNull
    private Long phoneNumber;
    @NotBlank
    private String address;
    @Enumerated(EnumType.STRING)
    private LibraryUserType libraryUserType;
}
