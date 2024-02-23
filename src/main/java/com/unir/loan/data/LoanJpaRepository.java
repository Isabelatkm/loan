package com.unir.loan.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.loan.model.db.Loan;



public interface LoanJpaRepository extends JpaRepository<Loan, Long> {
}
