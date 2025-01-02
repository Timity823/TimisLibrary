package com.timity.timislibrary.service;

import com.timity.timislibrary.controller.dto.BookRequest;
import com.timity.timislibrary.repository.Bookshelf;
import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final Bookshelf bookshelf;

    @Autowired
    public BookService(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public void insertNewBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setBookType(book.getBookType());
        bookEntity.setDescription(book.getDescription());

        bookshelf.save(bookEntity);
    }

}
