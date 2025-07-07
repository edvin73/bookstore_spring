package com.edvin.projects.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edvin.projects.bookstore.dto.AuthorDTO;
import com.edvin.projects.bookstore.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	// Get all authors
	@GetMapping("/")
	public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
		List<AuthorDTO> authors = authorService.getAllAuthors();
		
		return new ResponseEntity<List<AuthorDTO>>(authors, HttpStatus.OK);
	}
	
	// Get author by ID
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer id) {
		AuthorDTO author = authorService.getAuthorById(id);
		if (author != null) {
			return new ResponseEntity<AuthorDTO>(author, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Create a new author
	@PostMapping("/")
	public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
		if (authorDTO == null || authorDTO.lastName() == null) {
			return ResponseEntity.badRequest().build(); // Handle invalid input
		}

		AuthorDTO createdAuthor = authorService.createAuthor(authorDTO);
		
		return new ResponseEntity<AuthorDTO>(createdAuthor, HttpStatus.CREATED);
	}
	
	// Delete an author by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable Integer id) {
		if (id == null) {
			return ResponseEntity.badRequest().build(); // Handle invalid input
		}

		AuthorDTO deletedAuthor = authorService.deleteAuthor(id);
		if (deletedAuthor != null) {
			return new ResponseEntity<AuthorDTO>(deletedAuthor, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
