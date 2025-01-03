package com.timity.timislibrary.service;

import com.timity.timislibrary.repository.Bookshelf;
import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void modifyExtendedBook(Book book) {
        if (book.getId() == null) {
            throw new UnsupportedOperationException();
        }
        Optional<BookEntity> bookEntityOptional = bookshelf.findById(book.getId());
        if (bookEntityOptional.isPresent()){
            BookEntity existingBook = bookEntityOptional.get();
            if (existingBook.getTitle() !=null){
                existingBook.setTitle(book.getTitle());
            }
            if (existingBook.getAuthor() != null){
                existingBook.setAuthor(book.getAuthor());
            }
            if (existingBook.getBookType() != null){
                existingBook.setBookType(book.getBookType());
            }
            if (existingBook.getDescription() != null){
                existingBook.setDescription(book.getDescription());
            }
            bookshelf.save(existingBook);
        }
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

}
