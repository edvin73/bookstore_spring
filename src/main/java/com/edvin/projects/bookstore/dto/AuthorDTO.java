package com.edvin.projects.bookstore.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
 

public record AuthorDTO(Integer id,
						String firstName,
						String lastName,
						@JsonFormat(pattern = "yyyy-MM-dd")
						LocalDate dateOfBirth,
						@JsonFormat(pattern = "yyyy-MM-dd")
						LocalDate dateOfDeath,
						CountryDTO nationality,
						@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
						LocalDateTime createdAt,
						@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
						LocalDateTime updatedAt) {

}
