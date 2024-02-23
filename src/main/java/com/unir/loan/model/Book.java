package com.unir.loan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
	private Long id;
	private String title;
	private String author;
	private String published;
	private String isbn10;
	private String isbn13;
	private String summary;
	private String reviews;
	private String publisher;
	private String cantidad;
}
