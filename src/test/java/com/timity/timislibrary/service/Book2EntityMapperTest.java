package com.timity.timislibrary.service;

import com.timity.timislibrary.repository.entity.BookEntity;
import com.timity.timislibrary.service.model.book.Book;
import com.timity.timislibrary.service.model.book.BookType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Book2EntityMapperTest {
    @Test
    public void testBook2Entity() {
        //Given
        Book2EntityMapper underTest = new Book2EntityMapper(); // First step

        Book input = new Book();  //Third step
        input.setId(10);
        input.setTitle("a");
        input.setAuthor("b");
        input.setBookType(BookType.HISTORY);
        input.setDescription("c");


        //When
        BookEntity result = underTest.convert(input); //Second step

        //Then
        Assertions.assertEquals(10,result.getId());
        Assertions.assertEquals("a",result.getTitle());
        Assertions.assertEquals("b",result.getAuthor());
        Assertions.assertEquals(BookType.HISTORY,result.getBookType());
        Assertions.assertEquals("c",result.getDescription());
    }

}