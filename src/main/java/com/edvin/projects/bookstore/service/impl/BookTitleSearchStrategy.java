package com.edvin.projects.bookstore.service.impl;

import java.util.List;

import com.edvin.projects.bookstore.entity.Book;
import com.edvin.projects.bookstore.entity.LibraryItem;
import com.edvin.projects.bookstore.service.SearchStrategy;

public class BookTitleSearchStrategy implements SearchStrategy  {

	@Override
	public List<LibraryItem> search(List<LibraryItem> items, String query) {
		
		return items.stream()
			.filter(b -> b.getTitle().toLowerCase().startsWith(query.toLowerCase()))
			.toList();
		 
	}

}
