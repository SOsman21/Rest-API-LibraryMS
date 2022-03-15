package com.qa.libraryms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.libraryms.domain.Book;

public interface LibraryMSRepo extends JpaRepository<Book, Long>{
	

}
