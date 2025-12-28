package com.edvin.projects.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edvin.projects.bookstore.entity.Book;
import com.edvin.projects.bookstore.entity.LibraryItem;
import com.edvin.projects.bookstore.service.SearchStrategy; 
import com.edvin.projects.bookstore.service.impl.BookTitleSearchStrategy;
import com.edvin.projects.bookstore.service.impl.ClassificationSearchStrategy;
import com.edvin.projects.bookstore.service.impl.KeywordSearchStrategy;
import com.edvin.projects.bookstore.service.impl.LibraryItemServiceImpl; 

@RestController
@RequestMapping("/items")
public class LibraryItemController {
	
	private final LibraryItemServiceImpl service;
	
	public LibraryItemController(LibraryItemServiceImpl service) {
		this.service = service;
	}
	
	@PostMapping("/item")
	public ResponseEntity<?> addItem(@RequestBody Book book) {
		
		service.addItem(book);
		
		return new ResponseEntity<>("Item added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/search")
    public List<LibraryItem> search(@RequestParam String query,
                                    @RequestParam String strategy) {
        SearchStrategy  searchStrategy = 
        		switch (strategy.toLowerCase()) {
		            case "keyword" -> new KeywordSearchStrategy();
		            case "classification" -> new ClassificationSearchStrategy();
		            case "title" -> new BookTitleSearchStrategy();
		            default -> throw new IllegalArgumentException("Unknown strategy");
        		};
        
        List<LibraryItem> results = service.searchItems(query, searchStrategy, service.getAllItems());
        		
        return results;
    }	


}
