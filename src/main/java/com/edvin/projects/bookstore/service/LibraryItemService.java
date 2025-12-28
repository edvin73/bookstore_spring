package com.edvin.projects.bookstore.service;

import java.util.List;
 
import com.edvin.projects.bookstore.entity.LibraryItem; 

public interface LibraryItemService {
	
	LibraryItem addItem(LibraryItem item);
	
	LibraryItem removeItem(LibraryItem item);
	
	LibraryItem updateItem(LibraryItem item);
	
	List<LibraryItem> getAllItems();
	
	List<LibraryItem> searchItems(String query, SearchStrategy strategy, List<LibraryItem> items);

}
