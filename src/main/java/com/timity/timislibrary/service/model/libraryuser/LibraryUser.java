package com.timity.timislibrary.service.model.libraryuser;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUser {

    private Integer libraryUserId;
    @NotBlank
    private String name;
    private String email;
    @NotNull
    private Long phoneNumber;
    @NotBlank
    private String address;
    private LibraryUserType libraryUserType; //Introduce List Later
}
