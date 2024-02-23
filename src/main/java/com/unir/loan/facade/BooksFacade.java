package com.unir.loan.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.unir.loan.model.Book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class BooksFacade {
	  
	  
	  @Autowired
	  private final RestTemplate restTemplate;
	  
		  @Value("${getBook.url}")
		  private String getBookUrl;

	  public Book getBook(String id) {

	    try {
	      String url = String.format(getBookUrl, id);
	      log.info("Getting product with ID {}. Request to {}", id, url);
	      return restTemplate.getForObject(url, Book.class);
	    } catch (HttpClientErrorException e) {
	    	 log.info("HttpClientErrorException isa", e);
	      return null;
	    } catch (HttpServerErrorException e) {
	    	 log.info("HttpServerErrorException isa", e);
	      return null;
	    } catch (Exception e) {
	    	 log.info("Exception isa", e);
	      return null;
	    }
	  }
}
