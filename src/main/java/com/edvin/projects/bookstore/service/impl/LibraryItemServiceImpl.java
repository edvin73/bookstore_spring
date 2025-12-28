package com.edvin.projects.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edvin.projects.bookstore.entity.Book;
import com.edvin.projects.bookstore.entity.LibraryItem;
import com.edvin.projects.bookstore.handler.ApiError; 
import com.edvin.projects.bookstore.repository.ILibraryItemRepository; 
import com.edvin.projects.bookstore.service.LibraryItemService;
import com.edvin.projects.bookstore.service.SearchStrategy;
import com.edvin.projects.bookstore.handler.ResourceNotFoundException;
 
@Service

public class LibraryItemServiceImpl implements LibraryItemService {
	
	private final ILibraryItemRepository itemRepository; 
	
	
	public LibraryItemServiceImpl(ILibraryItemRepository itemRepository) {
	 
		this.itemRepository = itemRepository;
	}

	private List<LibraryItem> items = new ArrayList<>();

	@Override
	@Transactional(rollbackFor = Exception.class)
	public LibraryItem addItem(LibraryItem item) {
		
		LibraryItem newItem = itemRepository.save(item);
		items.add(newItem);
		
		return newItem;
		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public LibraryItem removeItem(LibraryItem item) {
		
		itemRepository.delete(item);		
		items.remove(item);		
		return item;
		
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, ResourceNotFoundException.class})
	public LibraryItem updateItem(LibraryItem item) {
		
		LibraryItem oldItem = new LibraryItem();
		
		oldItem.setDescription(item.getDescription());
		oldItem.setIsbn(item.getIsbn());
		oldItem.setNumberOfCopies(item.getNumberOfCopies());
		oldItem.setTitle(item.getTitle());
		
		oldItem.setAuthors(item.getAuthors());
		
		return oldItem;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LibraryItem> searchItems(String query, SearchStrategy strategy, List<LibraryItem> items) {
		
		
		return strategy.search(items, query);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LibraryItem> getAllItems() {
		
		items = itemRepository.findAll(); 
		return items;
	}

	 

}
