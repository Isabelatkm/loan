package com.unir.loan.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.loan.data.LoanJpaRepository;
import com.unir.loan.facade.BooksFacade;
import com.unir.loan.model.Book;
import com.unir.loan.model.db.Loan;
import com.unir.loan.model.request.LoanRequest;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class LoansServiceImpl implements LoansService {

	  @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
	  private BooksFacade booksFacade;

	  @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
	  private LoanJpaRepository repository;

	  @Override
	  public Loan createLoan(LoanRequest request) {
		  log.info(" Request to {}");
	    List<Book> books = request.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();
	    log.info(" Request to {}2");
	   
	    	  log.info(" Request to {}4");
	      Loan loan = Loan.builder().books(books.stream().map(Book::getId).collect(Collectors.toList())).build();
	      repository.save(loan);
	      return loan;
	    
	  }

	  @Override
	  public Loan getLoan(String id) {
	    return repository.findById(Long.valueOf(id)).orElse(null);
	  }

	  @Override
	  public List<Loan> getLoans() {
	    List<Loan> loans = repository.findAll();
	    return loans.isEmpty() ? null : loans;
	  }
}
