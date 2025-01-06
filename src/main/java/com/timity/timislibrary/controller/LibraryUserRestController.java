package com.timity.timislibrary.controller;

import com.timity.timislibrary.service.LibraryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/library-users")
public class LibraryUserRestController {
    private LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserRestController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }
}
