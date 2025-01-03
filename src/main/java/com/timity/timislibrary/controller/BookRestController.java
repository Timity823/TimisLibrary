package com.timity.timislibrary.controller;

import com.timity.timislibrary.controller.dto.BookRequest;
import com.timity.timislibrary.controller.dto.LibraryUserRequest;
import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.BookService;
import com.timity.timislibrary.service.model.book.Book;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/books")
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewBookToShelf(@Valid @RequestBody BookRequest bookRequest) {
        try {
            bookService.insertNewBook(bookRequest.getBook());
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        } catch (Exception e) {
            log.warn("Insertion failed", e);
            return ResponseEntity.status(HttpStatusCode.valueOf(406)).build();
        }
    }
    @PutMapping
    public ResponseEntity<Void> updateExistingBook(@Valid @RequestBody BookRequest bookRequest) {
        try {
            bookService.modifyExtendedBook(bookRequest.getBook());
            log.info("updated Book:{}", bookRequest);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
        } catch (Exception e) {
            log.warn("Update is failed", e);
            return ResponseEntity.status(HttpStatusCode.valueOf(406)).build();
        }
    }

    @DeleteMapping
    public void clearTheShelf(){
        bookService.deleteAllBooksFromShelf();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Integer bookId) {
        try {
            log.info("deleted Book successfully");
            bookService.removeBookById(bookId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.warn("Deleting denied", e);
            return ResponseEntity.notFound().build();
        }
    }



}
