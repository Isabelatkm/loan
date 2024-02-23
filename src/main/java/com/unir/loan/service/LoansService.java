package com.unir.loan.service;

import java.util.List;

import com.unir.loan.model.db.Loan;
import com.unir.loan.model.request.LoanRequest;


public interface LoansService {

	Loan createLoan(LoanRequest request);

	Loan getLoan(String id);

	List<Loan> getLoans();
	
}
