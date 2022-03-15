package com.qa.libraryms.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.libraryms.domain.Book;
import com.qa.libraryms.repo.LibraryMSRepo;

@SpringBootTest
@ActiveProfiles("test")
public class LibraryServiceDBTest {

	private Book book;
	private long isbn = 9781234567897L;

	@Autowired
	private LibraryMSServiceDB service;

	@MockBean
	private LibraryMSRepo repo;

	@BeforeEach
	void setUp() {
		book = new Book(9781234567897L, "name1", "edition1", "author1", "genre1", "publisher1", 1);
	}

	@Test
	void createTest() {
		Mockito.when(this.repo.save(book)).thenReturn(book);
		assertThat(this.service.create(book)).isEqualTo(book);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(book);
	}

	@Test
	void readAllTest() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		Mockito.when(this.repo.findAll()).thenReturn(bookList);
		assertThat(this.service.read()).isEqualTo(bookList);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void readByIsbnTest() {
		Optional<Book> opt = Optional.of(book);
		Mockito.when(this.repo.findById(isbn)).thenReturn(opt);
		assertThat(this.service.readByIsbn(isbn)).isEqualTo(book);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(isbn);
	}

	@Test
	void updateTest() {
		Book currentBook = new Book(isbn, "name1", "edition1", "author1", "genre1", "publisher1", 1);
		Optional<Book> opt = Optional.of(book);

		Book updated = new Book(currentBook.getIsbn(), currentBook.getName(), currentBook.getEdition(),
				currentBook.getAuthor(), currentBook.getGenre(), currentBook.getPublisher(), currentBook.getQuantity());

		Mockito.when(this.repo.findById(isbn)).thenReturn(opt);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		assertThat(this.service.update(isbn, currentBook)).isEqualTo(updated);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(isbn);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	void deleteTest() {
		Optional<Book> opt = Optional.of(book);

		Mockito.when(this.repo.findById(isbn)).thenReturn(opt);
		assertThat(this.service.delete(isbn)).isEqualTo(book);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(isbn);
		Mockito.verify(this.repo, Mockito.times(1)).findById(isbn);

	}
}
