package com.qa.libraryms.service;

import java.util.List;

import com.qa.libraryms.domain.Book;

public interface LibraryMSInterface<T> {
	
	Book create(Book b);
	
	List<Book> read();
	
	Book update(int ISBN, Book b);
	
	Book delete(int ISBN);

}
