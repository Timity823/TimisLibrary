package com.timity.timislibrary.repository;

import com.timity.timislibrary.repository.entity.LibraryUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserStorage extends JpaRepository<LibraryUserEntity,Integer> {

}
