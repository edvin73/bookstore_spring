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
@Table(name = "MEMBER_TYPE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberType {
	
	@Id
	@GeneratedValue(generator = "SEQ_MEMBER_TYPE", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_MEMBER_TYPE", sequenceName = "SEQ_MEMBER_TYPE", allocationSize = 1)
	@Column(name = "MEMBER_TYPE_ID", nullable = false, unique = true)
	private Integer memberTypeId;
	
	@Column(name = "MEMBER_TYPE", nullable = false, unique = true)
	private String type;

	 
}
