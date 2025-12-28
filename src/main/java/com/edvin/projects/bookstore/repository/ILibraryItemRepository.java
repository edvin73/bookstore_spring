package com.edvin.projects.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.edvin.projects.bookstore.entity.LibraryItem;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ILibraryItemRepository extends JpaRepository<LibraryItem, Integer> {
	// This interface will extend JPARepository to provide CRUD operations for
	// LibraryItem entities.
	// Additional custom query methods can be defined here if needed.

}
