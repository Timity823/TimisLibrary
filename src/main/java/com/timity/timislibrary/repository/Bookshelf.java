package com.timity.timislibrary.repository;


import com.timity.timislibrary.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookshelf extends JpaRepository<BookEntity,Integer> {
}
