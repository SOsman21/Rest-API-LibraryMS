package com.qa.libraryms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long bookId;

	String isbn;
	String name;
	String edition;
	String author;
	String genre;
	String publisher;
	int quantity;

	public Book() {
		super();
	}
	
	

	public Book(long bookId, String isbn, String name, String edition, String author, String genre, String publisher,
			int quantity) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.name = name;
		this.edition = edition;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public Book(String isbn, String name, String edition, String author, String genre, String publisher, int quantity) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.edition = edition;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookId, edition, genre, isbn, name, publisher, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookId == other.bookId
				&& Objects.equals(edition, other.edition) && Objects.equals(genre, other.genre)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(name, other.name)
				&& Objects.equals(publisher, other.publisher) && quantity == other.quantity;
	}
	
	

}
