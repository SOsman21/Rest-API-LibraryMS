package com.qa.libraryms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	int ISBN;// ISBN are unique to books so I'm using it as a primary key

	String name;
	String edition;
	String author;
	String genre;
	String publisher;
	int quantity;

	public Book() {
		super();
	}

	public Book(int iSBN, String name, String edition, String author, String genre, String publisher, int quantity) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.edition = edition;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
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
		return Objects.hash(ISBN, author, edition, genre, name, publisher, quantity);
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
		return ISBN == other.ISBN && Objects.equals(author, other.author) && Objects.equals(edition, other.edition)
				&& Objects.equals(genre, other.genre) && Objects.equals(name, other.name)
				&& Objects.equals(publisher, other.publisher) && quantity == other.quantity;
	}

}
