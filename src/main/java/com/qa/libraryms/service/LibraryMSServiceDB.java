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
		String exists = this.repo.findBookByIsbn(b.getIsbn()); 
		if (exists == null) {
			return this.repo.save(b);
		} else {
			return this.repo.save(updateQuantity(b));
		}
	}

	@Override
	public List<Book> read() {
		return this.repo.findAll();
	}

	@Override
	public Book readById(long bookId) {
		Optional<Book> opt = this.repo.findById(bookId);
		return opt.orElse(null);
	}

	@Override
	public Book update(long bookId, Book b) {
		Optional<Book> opt = this.repo.findById(bookId);
		Book currentBook = opt.get();
		currentBook.setBookId(b.getBookId());
		currentBook.setIsbn(b.getIsbn());
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
	public Book updateQuantity(Book b) {
		int quantity = b.getQuantity() + 1;
		b.setBookId(b.getBookId());
		b.setIsbn(b.getIsbn());
		b.setName(b.getName());
		b.setEdition(b.getEdition());
		b.setAuthor(b.getAuthor());
		b.setAuthor(b.getAuthor());
		b.setGenre(b.getGenre());
		b.setPublisher(b.getPublisher());
		b.setQuantity(quantity);
		return b;
	}

	@Override
	public Book delete(long bookId) {
		Optional<Book> book = this.repo.findById(bookId);
		this.repo.deleteById(bookId);
		return book.orElse(null);
	}

	

}
