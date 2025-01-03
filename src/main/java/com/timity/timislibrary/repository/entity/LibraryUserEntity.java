package com.timity.timislibrary.repository.entity;

import com.timity.timislibrary.service.model.libraryuser.LibraryUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "library_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUserEntity {
    @Id
    @GeneratedValue
    private Integer libraryUser_id;
    @NotBlank
    private String name;
    @NotBlank
    private String eMail;
    @NotNull
    private Long phoneNumber;
    @NotBlank
    private String address;
    private LibraryUserType libraryUserType;

}
