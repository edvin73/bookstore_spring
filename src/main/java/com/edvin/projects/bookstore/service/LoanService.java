package com.edvin.projects.bookstore.service;

import java.math.BigDecimal;
import java.util.List;

import com.edvin.projects.bookstore.entity.Loan;

public interface LoanService  {
	
	
	// Create a new loan to a member
	Loan  createLoan(Integer itemCopyId, Integer memberId);
	
	// Return the item and close the loan
	Boolean returnItem(Integer loanId);
	
	// Renew a loan
	Boolean renewLoan(Integer loanId);
	
	// Check if a book is currently on loan
	boolean isItemOnLoan(Integer itemCopyId);
	
	// Get list of active loans by memeber
	List<Loan> getActiveLoansByMember(Integer memberId);
	
	// Get loan by Id
	Loan getLoanById(Integer loanId);
	
	// Get overdue loans
	List<Loan> getOverdueLoans();
	
	// Calculate fines for a loan
    BigDecimal calculateFine(Integer loanId);



}
