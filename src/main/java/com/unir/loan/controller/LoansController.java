package com.unir.loan.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unir.loan.model.db.Loan;
import com.unir.loan.model.request.LoanRequest;
import com.unir.loan.service.LoansService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoansController {

	private final LoansService service;
	
	  @PostMapping("/loans")
	    public ResponseEntity<Loan> createOrder(@RequestBody @Valid LoanRequest request) { //Se valida con Jakarta Validation API

	       
	        Loan created = service.createLoan(request);

	        if (created != null) {
	            return ResponseEntity.ok(created);
	        } else {
	            return ResponseEntity.badRequest().build();
	        }
	    }

	    @GetMapping("/loans")
	    public ResponseEntity<List<Loan>> getLoans() {

	        List<Loan> loans = service.getLoans();
	        if (loans != null) {
	            return ResponseEntity.ok(loans);
	        } else {
	            return ResponseEntity.ok(Collections.emptyList());
	        }
	    }

	    @GetMapping("/loans/{id}")
	    public ResponseEntity<Loan> getOrder(@PathVariable String id) {

	        Loan order = service.getLoan(id);
	        if (order != null) {
	            return ResponseEntity.ok(order);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
