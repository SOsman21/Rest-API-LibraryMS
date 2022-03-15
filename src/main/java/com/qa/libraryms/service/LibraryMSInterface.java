package com.qa.libraryms.service;

import java.util.List; 

import com.qa.libraryms.domain.Book;

public interface LibraryMSInterface<T> {
	
	Book create(Book b);
	
	List<Book> read();

	Book readByIsbn(long isbn);

	Book update(long isbn, Book b);
	
	Book delete(long isbn);

}
