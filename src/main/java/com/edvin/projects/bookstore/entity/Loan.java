package com.edvin.projects.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOAN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5888948116542554441L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOAN")
	@SequenceGenerator(name = "SEQ_LOAN", sequenceName = "SEQ_LOAN", allocationSize = 1)
	@Column(name = "LOAN_ID", nullable = false, unique = true)
	private Integer loanId;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member; 
	
	@ManyToOne
	@JoinColumn(name = "ITEM_COPY_ID", nullable = false)
	private LibraryItemCopy itemCopy; // The specific copy of the item being loaned
	
	@ManyToOne
	@JoinColumn(name = "LOAN_STATUS_ID", nullable = false)
	private LoanStatus loanStatus;
	
	@Column(name = "LOAN_DATE", nullable = false) // The date when the loan was made
	private LocalDateTime loanDate;
	
	@Column(name = "DUE_DATE", nullable = false)
	private LocalDate dueDate; // The date when the loan is due
	
	@Column(name = "RETURN_DATE", nullable = true)
	private LocalDate returnDate; // The date when the item was returned

}
