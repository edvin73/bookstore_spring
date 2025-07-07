package com.edvin.projects.bookstore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edvin.projects.bookstore.entity.Author;
import com.edvin.projects.bookstore.entity.Country;
import com.edvin.projects.bookstore.dto.AuthorDTO;
import com.edvin.projects.bookstore.util.ReferencesMapper;
import com.edvin.projects.bookstore.repository.IAuthor;

@Service
public class AuthorService {
	
	private final IAuthor authorRepository;
	
	public AuthorService(IAuthor authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	//getAllAuthors
	public List<AuthorDTO> getAllAuthors() {
		return authorRepository.findAll()
					.stream()
					.map(ReferencesMapper::mapAuthorToDTO)
					.collect(Collectors.toList());
	}
	
	//getAuthorById
	public AuthorDTO getAuthorById(Integer id) {
		return authorRepository.findById(id).
					map(ReferencesMapper::mapAuthorToDTO).orElse(null);
	}
	
	//createAuthor
	public AuthorDTO createAuthor(AuthorDTO authorDTO) {
		if (authorDTO == null || authorDTO.firstName() == null || authorDTO.lastName() == null) {
			return null; // Handle invalid input
		}

		var author = ReferencesMapper.mapAuthorDtoToAuthor(authorDTO);
		
		author.setCreatedAt(LocalDateTime.now());
		
		
		var savedAuthor = authorRepository.save(author);
		
		return ReferencesMapper.mapAuthorToDTO(savedAuthor);
	}
	
	//deleteAuthor
	public AuthorDTO deleteAuthor(Integer id) {
		if (id == null) {
			return null; // Handle invalid input
		}

		authorRepository.deleteById(id);
		
		return getAuthorById(id); 
	}
	
	//updateAuthor
	public AuthorDTO update(AuthorDTO authorDTO) {
		
		var author = ReferencesMapper.mapAuthorDtoToAuthor(authorDTO);
		
		if (author.getId() == null) {
			return null; // Handle invalid input
		}
		
		var originalAuthor = authorRepository.findById(author.getId()).orElse(null);
		
		if (originalAuthor == null) {
			return null; // Handle case where author does not exist
		}
		
		// Update fields
		if (authorDTO.firstName() != null && !authorDTO.firstName().equals(originalAuthor.getFirstName())) {
			originalAuthor.setFirstName(authorDTO.firstName());
		}
		
		if (authorDTO.lastName() != null && !authorDTO.lastName().equals(originalAuthor.getLastName())) {
			originalAuthor.setLastName(authorDTO.lastName());
		}
		if (authorDTO.dateOfBirth() != null && !authorDTO.dateOfBirth().equals(originalAuthor.getDateOfBirth())) {
			originalAuthor.setDateOfBirth(authorDTO.dateOfBirth());
		}
		if (authorDTO.dateOfDeath() != null && !authorDTO.dateOfDeath().equals(originalAuthor.getDateOfDeath())) {
			originalAuthor.setDateOfDeath(authorDTO.dateOfDeath());
		}
		
		if(authorDTO.nationality() != null && !authorDTO.nationality().equals(originalAuthor.getNationality())) {
			originalAuthor.setNationality(ReferencesMapper.mapCountryDTOToCountry(authorDTO.nationality()));
		}
		
		originalAuthor.setUpdatedAt(LocalDateTime.now());
		
		return ReferencesMapper.mapAuthorToDTO(authorRepository.save(originalAuthor));
	}
}
