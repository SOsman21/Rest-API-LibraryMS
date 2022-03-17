package com.qa.libraryms.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.libraryms.domain.Book;
import com.qa.libraryms.service.LibraryMSServiceDB;

@RestController
public class LibraryMSController {

	private LibraryMSServiceDB service;

	public LibraryMSController(LibraryMSServiceDB service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Book> createAnimal(@RequestBody Book b) {
		return new ResponseEntity<Book>(this.service.create(b), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("readAll")
	public List<Book> readAnimal() {
		return this.service.read();
	}

	// READ BY ID
	@GetMapping("/readById/{bookId}")
	public ResponseEntity<Book> readById(@PathVariable long bookId) {
		return new ResponseEntity<Book>(this.service.readById(bookId), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/update/{bookId}")
	public ResponseEntity<Book> update(@PathVariable long bookId, @RequestBody Book updated) {
		return new ResponseEntity<Book>(this.service.update(bookId, updated), HttpStatus.CREATED);
	}

	// DELETE
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<Book> delete(@PathVariable long bookId) {
		return new ResponseEntity<Book>(this.service.delete(bookId), HttpStatus.CREATED);
	}

}
