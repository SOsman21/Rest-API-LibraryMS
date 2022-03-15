package com.qa.libraryms.service;

import java.util.List; 

import com.qa.libraryms.domain.Book;

public interface LibraryMSInterface<T> {
	
	Book create(Book b);
	
	List<Book> read();
	
<<<<<<< HEAD
	Book readByISBN(int isbn);
=======
	Book readByIsbn(int isbn);
>>>>>>> b0daf599c819124040cfdd2f9bc311222529cc5a
	
	Book update(int isbn, Book b);
	
	Book delete(int isbn);

}
