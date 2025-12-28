package com.edvin.projects.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.edvin.projects.bookstore.entity.LibraryItemCopy;

@Repository
public interface ILibraryItemCopy extends JpaRepository<LibraryItemCopy, Integer> {

}
