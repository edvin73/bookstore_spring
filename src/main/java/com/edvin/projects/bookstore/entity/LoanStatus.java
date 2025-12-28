package com.edvin.projects.bookstore.entity;

import java.io.Serializable;

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
@Table(name = "LOAN_STATUS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5303192162291493377L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOAN_STATUS")
	@SequenceGenerator(name = "SEQ_LOAN_STATUS", sequenceName = "SEQ_LOAN_STATUS", allocationSize = 1)
	@Column(name = "LOAN_STATUS_ID", nullable = false, unique = true)
	private Integer loanStatusId;
	
	@Column(name = "STATUS_NAME", nullable = false, unique = true, length = 30)
	private String statusName;

}
