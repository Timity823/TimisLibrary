package com.timity.timislibrary.controller;

import com.timity.timislibrary.controller.dto.BookRequest;
import com.timity.timislibrary.controller.dto.BookResponse;
import com.timity.timislibrary.service.BookCrudService;
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

    private final BookCrudService bookService;

    @Autowired
    public BookRestController(BookCrudService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addNewBookToShelf(@Valid @RequestBody BookRequest bookRequest) {
        try {
            Book book = bookService.insertNewBook(bookRequest.getBook());
            BookResponse bookResponse = new BookResponse(book);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(bookResponse);
        } catch (Exception e) {
            log.warn("Insertion failed", e);
            return ResponseEntity.status(HttpStatusCode.valueOf(406)).build();
        }
    }
    @PutMapping
    public ResponseEntity<Void> updateExistingBook(@Valid @RequestBody BookRequest bookRequest) { //return the updated object
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
    //TODO: get endpoints



}
