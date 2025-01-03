package com.timity.timislibrary.service;

import com.timity.timislibrary.repository.LibraryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserService {
    private final LibraryUserStorage libraryUserStorage;

    @Autowired
    public LibraryUserService(LibraryUserStorage libraryUserStorage) {
        this.libraryUserStorage = libraryUserStorage;
    }
}
