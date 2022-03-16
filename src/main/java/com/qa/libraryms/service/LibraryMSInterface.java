package com.qa.libraryms.service;

import java.util.List; 

import com.qa.libraryms.domain.Book;

public interface LibraryMSInterface<T> {
	
	Book create(Book b);
	
	List<Book> read();

	Book readById(long bookId);

	Book update(long bookId, Book b);
	
	Book delete(long bookId);

}
