package com.timity.timislibrary.repository.entity;

import com.timity.timislibrary.service.model.libraryuser.LibraryUserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "library-users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryUserEntity {
    @Id
    @GeneratedValue
    @Column(name = "library_user_id")
    private Integer libraryUserId;

    private String name;

    private String eMail;

    private Long phoneNumber;

    private String address;
    @Enumerated(EnumType.STRING)
    private LibraryUserType libraryUserType;

}
