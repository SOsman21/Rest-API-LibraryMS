package com.qa.libraryms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.libraryms.domain.Book;
import com.qa.libraryms.repo.LibraryMSRepo;

@Service
public class LibraryMSServiceDB implements LibraryMSInterface<Integer>{
	
	private LibraryMSRepo repo;

	public LibraryMSServiceDB(LibraryMSRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Book create(Book b) {
		return this.repo.save(b);
	}

	@Override
	public List<Book> read() {
		return this.repo.findAll();
	}

	@Override
	public Book readByISBN(int isbn) {
		Optional<Book> opt = this.repo.findById(isbn);
		return opt.orElse(null);
	}

	@Override
	public Book update(int isbn, Book b) {
		Optional<Book> opt =  this.repo.findById(isbn);
		Book currentBook = opt.get();
		currentBook.setIsbn(isbn);
		currentBook.setName(b.getName());
		currentBook.setEdition(b.getEdition());
		currentBook.setAuthor(b.getAuthor());
		currentBook.setAuthor(b.getAuthor());
		currentBook.setGenre(b.getGenre());
		currentBook.setPublisher(b.getPublisher());
		currentBook.setQuantity(b.getQuantity());
		return this.repo.save(currentBook);
	}

	@Override
	public Book delete(int isbn) {
		Optional<Book> book = this.repo.findById(isbn);
		this.repo.deleteById(isbn);
		return book.orElse(null);
	}
	
	

}
