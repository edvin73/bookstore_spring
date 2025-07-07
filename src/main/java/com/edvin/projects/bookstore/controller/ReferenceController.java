package com.edvin.projects.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edvin.projects.bookstore.dto.CountryDTO;
import com.edvin.projects.bookstore.service.CountryService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/references")
public class ReferenceController {
	
	private final CountryService countryService;
	
	public ReferenceController(CountryService referenceService) {
		this.countryService = referenceService;
	}
	
	@GetMapping("/countries")
	public List<CountryDTO> getAllCountries() {
		return countryService.getAllCountries();
	}
	
	@GetMapping("/countries/{id}")
	public CountryDTO getCountryById(@PathVariable Integer id) {
		return countryService.getCountryById(id);
	}
	
	@PostMapping("/countries")
	public CountryDTO createCountr(@RequestBody CountryDTO countryDAO) {
		if (countryDAO == null || countryDAO.getCode() == null || countryDAO.getName() == null) {
			return null; // Handle invalid input
		}

		return countryService.createCountry(countryDAO);
	}
	
	@DeleteMapping("/countries/{id}")
	public void deleteCountry(@PathVariable Integer id) {
		if (id == null) {
			return; // Handle invalid input
		}

		countryService.deleteCountry(id);
	}
}
