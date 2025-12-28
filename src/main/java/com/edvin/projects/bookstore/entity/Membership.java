package com.edvin.projects.bookstore.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBERSHIP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Membership {
	
	@Id
	@Column(name = "MEMBERSHIP_ID", nullable = false, unique = true)
	private Integer membershipId;
	
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;
	
	@Column(name = "MEMBERSHIP_TYPE", nullable = false)
	private String membershipType;
	
	@Column(name = "START_DATE", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private LocalDate endDate;
	
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT", nullable = true)
	private LocalDateTime updatedAt;
	
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active;

}
