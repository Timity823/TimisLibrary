package com.timity.timislibrary.service;

import com.timity.timislibrary.repository.Bookshelf;
import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookCrudService {
    private final Book2EntityMapper book2EntityMapper;
    private final Bookshelf bookshelf;

    @Autowired
    public BookCrudService(Book2EntityMapper book2EntityMapper, Bookshelf bookshelf) {
        this.book2EntityMapper = book2EntityMapper;
        this.bookshelf = bookshelf;
    }


    public Book insertNewBook(Book book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException();
        }
        BookEntity bookEntity = book2EntityMapper.convert(book);

        BookEntity savedBook = bookshelf.save(bookEntity);

        Book result = book2EntityMapper.convert(savedBook);
        return result;
    }

    public Book modifyExtendedBook(Book book) { //return updated book
        if (book.getId() == null) {
            throw new IllegalArgumentException();
        }
        Optional<BookEntity> bookEntityOptional = bookshelf.findById(book.getId());
        if (bookEntityOptional.isPresent()) {
            BookEntity existingBook = bookEntityOptional.get();
            if (existingBook.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }
            if (existingBook.getAuthor() != null) {
                existingBook.setAuthor(book.getAuthor());
            }
            if (existingBook.getBookType() != null) {
                existingBook.setBookType(book.getBookType());
            }
            if (existingBook.getDescription() != null) {
                existingBook.setDescription(book.getDescription());
            }
            bookshelf.save(existingBook);
        }
        return book;
    }

    public void deleteAllBooksFromShelf() {
        bookshelf.deleteAll();
    }

    public void removeBookById(Integer bookId) {
        if (bookId == null) {
            throw new UnsupportedOperationException();
        }
        bookshelf.deleteById(bookId);

    }

    public List<BookEntity> getAllBooksFromShelf() {
        return Collections.unmodifiableList(bookshelf.findAll());
    }

    public Book getBookById(Integer input) {
        Optional<BookEntity> optionalBookEntity = bookshelf.findById(input);

        if (optionalBookEntity.isEmpty()) {
            throw new IllegalArgumentException();
        }
        BookEntity simpleEntity = new BookEntity();
        simpleEntity.setId(optionalBookEntity.get().getId());
        simpleEntity.setTitle(optionalBookEntity.get().getTitle());
        simpleEntity.setAuthor(optionalBookEntity.get().getAuthor());
        simpleEntity.setBookType(optionalBookEntity.get().getBookType());
        simpleEntity.setDescription(optionalBookEntity.get().getDescription());

        return book2EntityMapper.convert(simpleEntity);
    }


}
