package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a country entity in the bookstore application. This class is used
 * to store information about countries. It implements Serializable for
 * potential serialization needs.
 */

@Entity
@Table(name = "COUNTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "SEQ_COUNTRY")
	@SequenceGenerator(name = "SEQ_COUNTRY", sequenceName = "SEQ_COUNTRY", allocationSize = 1)
	@Column(name = "COUNTRY_ID")
	private Integer id;
	
	@Column(name = "COUNTRY_CODE", nullable = false, unique = true, length = 3)
	private String code;
	
	@Column(name = "COUNTRY_NAME", nullable = false, length = 100)
	private String name;
	
	@Column(name = "STATUS", nullable = false, length = 1)
	private String status;
	
	@Column(name = "DATE_CREATED", nullable = false)
	private LocalDateTime  dateCreated;

}
