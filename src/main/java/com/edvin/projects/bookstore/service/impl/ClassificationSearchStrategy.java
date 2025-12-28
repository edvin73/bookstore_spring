package com.edvin.projects.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.edvin.projects.bookstore.entity.Book;
import com.edvin.projects.bookstore.entity.LibraryItem;
import com.edvin.projects.bookstore.service.SearchStrategy; 

public class ClassificationSearchStrategy implements SearchStrategy  {

	@Override
	public List<LibraryItem> search(List<LibraryItem> items, String query) {
		
		// Implement the logic to search for items based on classification
		// This could involve filtering items that match the classification query
		return items.stream()
				.filter(item -> item.getClassificationUDC().equalsIgnoreCase(query))
				.collect(Collectors.toList());
		
	}

}
