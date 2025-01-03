package com.timity.timislibrary.service.model.libraryuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    private String comment;
    private Rating rating;
}
