package com.edvin.projects.bookstore.entity;

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

@Entity
@Table(name = "MEMBERSHIP_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBERSHIP_TYPE")
	@SequenceGenerator(name = "SEQ_MEMBERSHIP_TYPE", sequenceName = "SEQ_MEMBERSHIP_TYPE", allocationSize = 1)
	private Integer membershipTypeId;
	
	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description; 

	

}
