package com.timity.timislibrary.service.model.libraryuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWorm {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
    private String address;
}
