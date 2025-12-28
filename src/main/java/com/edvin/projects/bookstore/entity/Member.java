package com.edvin.projects.bookstore.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "MEMBER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
	
	@Id
	@Column(name = "MEMBER_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMEBER")
	@SequenceGenerator(name = "SEQ_MEMEBER", sequenceName = "SEQ_MEMBER", allocationSize = 1)
	private Integer memberId;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;	
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "POSTAL_CODE", nullable = false)
	private String postalCode;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT", nullable = true)
	private LocalDateTime updatedAt; 
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_TYPE_ID", nullable = false)
	private MemberType memberType;

}
