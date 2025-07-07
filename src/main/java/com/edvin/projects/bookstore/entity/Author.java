package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTHOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "AUTHOR_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTHOR")
	@SequenceGenerator(name = "SEQ_AUTHOR", sequenceName = "SEQ_AUTHOR", allocationSize = 1)
	private Integer id;
	
	@Column(name = "FIRST_NAME", length = 100)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 100)
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dateOfBirth;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_DEATH")
	private LocalDate dateOfDeath;
	
	@ManyToOne
	@JoinColumn(name = "NATIONALITY_ID", referencedColumnName = "COUNTRY_ID")
	private Country nationality;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;
	 

	 

}
