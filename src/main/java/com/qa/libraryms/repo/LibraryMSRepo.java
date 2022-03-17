package com.qa.libraryms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.libraryms.domain.Book;

public interface LibraryMSRepo extends JpaRepository<Book, Long>{
	
	@Query(value = "SELECT isbn FROM book WHERE isbn = ?1", nativeQuery = true)
    String findBookByIsbn(String isbn); 

}
