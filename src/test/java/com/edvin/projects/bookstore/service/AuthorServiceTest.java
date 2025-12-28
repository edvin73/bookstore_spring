package com.edvin.projects.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.edvin.projects.bookstore.dto.AuthorDTO;
import com.edvin.projects.bookstore.entity.Author;
import com.edvin.projects.bookstore.repository.IAuthor;


class AuthorServiceTest {
	
	@Mock
	private IAuthor authorRepository;
	
	@InjectMocks
	private AuthorService authorService;
	
	public AuthorServiceTest() {
	    MockitoAnnotations.openMocks(this);
	}

//	@BeforeEach
//	void setUp() {
//		authorRepository = mock(IAuthor.class);
//		authorService = new AuthorService(authorRepository);
//	}
		
	 @Test // Test for getAllAuthors method
	 void testGetAllAuthors() {
	        // Arrange
	        var author1 = new Author();
	        author1.setId(1);
	        author1.setFirstName("William");
	        author1.setLastName("Shakespeare");

	        var author2 = new Author();
	        author2.setId(2);
	        author2.setFirstName("Jane");
	        author2.setLastName("Austen");

	        when(authorRepository.findAll()).thenReturn(Arrays.asList(author1, author2));

	        var expectedAuthorDTO1 = new AuthorDTO(1, "William", "Shakespeare", null, null, null, null, null);
	        var expectedAuthorDTO2 = new AuthorDTO(2, "Jane", "Austen", null, null, null, null, null);

	        // Act
	        List<AuthorDTO> result = authorService.getAllAuthors();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        assertEquals(expectedAuthorDTO1.firstName(), result.get(0).firstName());
	        assertEquals(expectedAuthorDTO2.firstName(), result.get(1).firstName());

	        verify(authorRepository, times(1)).findAll();
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