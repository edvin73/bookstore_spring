package com.edvin.projects.bookstore.service;

import java.util.List;
 
import com.edvin.projects.bookstore.entity.LibraryItem;

public interface SearchStrategy {
	
	/**
	 * Searches for library items based on the provided query.
	 *
	 * @param items the list of library items to search within
	 * @param query the search query string
	 * @return a list of library items that match the search criteria
	 */
	List<LibraryItem> search(List<LibraryItem> items, String query);
 
}
