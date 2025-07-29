package com.edvin.projects.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edvin.projects.bookstore.dto.AuthorDTO;
import com.edvin.projects.bookstore.entity.Author;
import com.edvin.projects.bookstore.repository.IAuthor;


class AuthorServiceTest {

	private IAuthor authorRepository;
	private AuthorService authorService;

	@BeforeEach
	void setUp() {
		authorRepository = mock(IAuthor.class);
		authorService = new AuthorService(authorRepository);
	}

	@Test
	void testGetAuthorById_AuthorExists() {
		Author author = new Author();
		author.setId(1);
		author.setFirstName("John");
		author.setLastName("Doe");
		when(authorRepository.findById(1)).thenReturn(Optional.of(author));

		AuthorDTO dto = authorService.getAuthorById(1);

		assertNotNull(dto);
		assertEquals("John", dto.firstName());
		assertEquals("Doe", dto.lastName());
	}

	@Test
	void testGetAuthorById_AuthorDoesNotExist() {
		when(authorRepository.findById(2)).thenReturn(Optional.empty());

		AuthorDTO dto = authorService.getAuthorById(2);

		assertNull(dto);
	}

	@Test
	void testCreateAuthor_ValidInput() {
		AuthorDTO inputDTO = new AuthorDTO(null, "Jane", "Smith", null, null, null, null, null);
		Author savedAuthor = new Author();
		savedAuthor.setId(1);
		savedAuthor.setFirstName("Jane");
		savedAuthor.setLastName("Smith");
		
		when(authorRepository.save(any(Author.class))).thenReturn(savedAuthor);
		
		AuthorDTO result = authorService.createAuthor(inputDTO);
		
		assertNotNull(result);
		assertEquals("Jane", result.firstName());
		assertEquals("Smith", result.lastName());
	}
	
	@Test
	void testCreateAuthor_NullInput() {
		AuthorDTO result = authorService.createAuthor(null);
		
		assertNull(result);
	}
	
	@Test
	void testCreateAuthor_MissingFirstName() {
		AuthorDTO inputDTO = new AuthorDTO(null, null, "Smith", null, null, null, null, null);
		
		AuthorDTO result = authorService.createAuthor(inputDTO);
		
		assertNull(result);
	}
	
	@Test
	void testCreateAuthor_MissingLastName() {
		AuthorDTO inputDTO = new AuthorDTO(null, "Jane", null, null, null, null, null, null);
		
		AuthorDTO result = authorService.createAuthor(inputDTO);
		
		assertNull(result);
	}
	
}