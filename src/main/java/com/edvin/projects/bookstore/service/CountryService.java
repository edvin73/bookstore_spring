package com.edvin.projects.bookstore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.edvin.projects.bookstore.dto.CountryDTO;
import com.edvin.projects.bookstore.entity.Country;
import com.edvin.projects.bookstore.handler.ResourceNotFoundException;
import com.edvin.projects.bookstore.repository.ICountry;
import com.edvin.projects.bookstore.util.ReferencesMapper;
import com.edvin.projects.bookstore.util.ReferencesMapper;

@Service
public class CountryService {
	
	private Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	private final ICountry countryRepository;
	 
	
	public CountryService(ICountry countryRepository) {
		this.countryRepository = countryRepository;
		  
	}
	
	/**
	 * Retrieves a country by its ID.
	 * 
	 * @param id the ID of the country to retrieve
	 * @return the country with the specified ID, or null if not found
	 */
	 public CountryDTO getCountryById(Integer id) {
			if (id == null) {
				return null;
			}
			
			return countryRepository.findById(id)
					.map(country -> ReferencesMapper.mapCountryToDTO(country))
					.orElseThrow( () -> new ResourceNotFoundException("Country not found with ID: " + id));
	 }
	 
	 /**
	  * 
	  * Retrieves a list of all countries order by name.
	  */
		public List<CountryDTO> getAllCountries() {
			
			
			
			return countryRepository.findAll().stream()
					.map(country -> ReferencesMapper.mapCountryToDTO(country))
					.sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())).toList();
		}
		
		/**
		 * Retrive a country by its code.
		 */
		public CountryDTO getCountryByCode(String code) {
			if (code == null || code.isBlank()) {
				return null;
			}

			return countryRepository.findAll().stream().filter(country -> country.getCode().equalsIgnoreCase(code))
					.map(country -> ReferencesMapper.mapCountryToDTO(country))
					.findFirst()
					.orElseThrow( () -> new ResourceNotFoundException("Country not found with code: " + code));
		}
		
		/**
		 * Create a new country.
		 */
		public CountryDTO createCountry(CountryDTO countryDAO) {
			if (countryDAO == null || countryDAO.getCode() == null || countryDAO.getName() == null) {
				return null;
			}

			Country country = new  Country();
			country.setCode(countryDAO.getCode());
			country.setName(countryDAO.getName());
			country.setStatus("A"); // Assuming 'A' is for active
			country.setDateCreated(LocalDateTime.now());

			country = countryRepository.save(country);

			return ReferencesMapper.mapCountryToDTO(country);
		}
		
		/**
		 * Update an existing country.
		 */
		public CountryDTO updateCountry(CountryDTO countryDAO) {
			if (countryDAO == null || countryDAO.getId() == null) {
				return null;
			}

			return countryRepository.findById(countryDAO.getId()).map(existingCountry -> {
				existingCountry.setCode(countryDAO.getCode());
				existingCountry.setName(countryDAO.getName());
				existingCountry.setStatus(countryDAO.getStatus());
				existingCountry.setDateCreated(LocalDateTime.now());

				existingCountry = countryRepository.save(existingCountry);

				return ReferencesMapper.mapCountryToDTO(existingCountry);
			})
			.orElseThrow( () -> new ResourceNotFoundException("Country not found with ID: " + countryDAO.getId()));
		}
		
		/**
		 * Delete a country by its ID.
		 */
		public boolean deleteCountry(Integer id) {
			
			if (id == null) {
				return false;
			}

			if (!countryRepository.existsById(id)) {
				throw new ResourceNotFoundException("Country not found with ID: " + id);
			}

			countryRepository.deleteById(id);
			return true;
		}

}
