package com.timity.timislibrary.service;

import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.model.book.Book;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class Book2EntityMapper {
    public Book convert(BookEntity bookEntity){
        Book result = new Book();
        result.setId(bookEntity.getId());
        result.setTitle(bookEntity.getTitle());
        result.setAuthor(bookEntity.getAuthor());
        result.setBookType(bookEntity.getBookType());
        result.setDescription(bookEntity.getDescription());
        return result;
    }

    public BookEntity convert(Book book){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setBookType(book.getBookType());
        bookEntity.setDescription(book.getDescription());
        return bookEntity;
    }

/*    public BookEntity convert(Optional<BookEntity> optionalBookEntity){
        BookEntity simpleEntity = new BookEntity();
        simpleEntity.setId(optionalBookEntity.get().getId());
        simpleEntity.setTitle(optionalBookEntity.get().getTitle());
        simpleEntity.setAuthor(optionalBookEntity.get().getAuthor());
        simpleEntity.setBookType(optionalBookEntity.get().getBookType());
        simpleEntity.setDescription(optionalBookEntity.get().getDescription());
        return simpleEntity;
    }*/

}
