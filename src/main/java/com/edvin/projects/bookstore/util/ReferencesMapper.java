package com.edvin.projects.bookstore.util;

import com.edvin.projects.bookstore.dto.AuthorDTO;
import com.edvin.projects.bookstore.dto.CountryDTO;
import com.edvin.projects.bookstore.entity.Author;
import com.edvin.projects.bookstore.entity.Country;

public class ReferencesMapper {
	
	public static CountryDTO mapCountryToDTO(Country country) {
		if (country == null) {
			return null;
		}
		
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setCode(country.getCode());
		countryDTO.setName(country.getName());
		countryDTO.setStatus(country.getStatus());
	
		return countryDTO;
				
	}
	
	public static Country mapCountryDTOToCountry(CountryDTO countryDTO) {
		if (countryDTO == null) {
			return null;
		}

		Country country = new Country();
		country.setId(countryDTO.getId());
		country.setCode(countryDTO.getCode());
		country.setName(countryDTO.getName());
		country.setStatus(countryDTO.getStatus());

		return country;
	}
	
	public static AuthorDTO mapAuthorToDTO(Author author) {
		if (author == null) {
			return null;
		}
  
		return new AuthorDTO(author.getId(), author.getFirstName(), author.getLastName(), author.getDateOfBirth(),
				author.getDateOfDeath(), mapCountryToDTO(author.getNationality()), author.getCreatedAt(),
				author.getUpdatedAt());

	}
	
	public static Author mapAuthorDtoToAuthor(AuthorDTO authorDTO) {
		
		if (authorDTO == null) {
			return null;
		}
		
		Author author = new Author();

		if (authorDTO.id() != null) {
			author.setId(authorDTO.id());
		}
		
		if (authorDTO.firstName() != null) {
			author.setFirstName(authorDTO.firstName());
		}
		
		if (authorDTO.lastName() != null) {
			author.setLastName(authorDTO.lastName());
		}
		
		if (authorDTO.dateOfBirth() != null) {
			author.setDateOfBirth(authorDTO.dateOfBirth());
		}
		
		if (authorDTO.dateOfDeath() != null) {
			author.setDateOfDeath(authorDTO.dateOfDeath());
		}
		
		if(authorDTO.nationality() != null) {			
			author.setNationality(ReferencesMapper.mapCountryDTOToCountry(authorDTO.nationality()));
		}
		
		if (authorDTO.createdAt() != null) {
            author.setCreatedAt(authorDTO.createdAt());
        }
		
		if (authorDTO.updatedAt() != null) {
            author.setUpdatedAt(authorDTO.updatedAt());
        }
		
		return author;
		
	}

}
