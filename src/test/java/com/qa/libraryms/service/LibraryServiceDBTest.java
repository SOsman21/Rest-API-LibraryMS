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

	private Book input;
	private Book returned;
	private long bookId;

	@Autowired
	private LibraryMSServiceDB service;

	@MockBean
	private LibraryMSRepo repo;

	@BeforeEach
	void setUp() {
		input = new Book("9781234567897", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		returned = new Book(1L,"9781234567897", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		bookId = 1L;
	}

	@Test
	void createTest() {
		Mockito.when(this.repo.save(input)).thenReturn(returned);
		assertThat(this.service.create(input)).isEqualTo(returned);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	void readAllTest() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(input);
		Mockito.when(this.repo.findAll()).thenReturn(bookList);
		assertThat(this.service.read()).isEqualTo(bookList);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void readByIdTest() {
		Optional<Book> opt = Optional.of(returned);
		Mockito.when(this.repo.findById(bookId)).thenReturn(opt);
		assertThat(this.service.readById(bookId)).isEqualTo(returned);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(bookId);
	}

	@Test
	void updateTest() {
		Book currentBook = new Book("9781234567834", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		Optional<Book> opt = Optional.of(returned);

		Book updated = new Book(currentBook.getIsbn(), currentBook.getName(), currentBook.getEdition(),
				currentBook.getAuthor(), currentBook.getGenre(), currentBook.getPublisher(), currentBook.getQuantity());

		Mockito.when(this.repo.findById(bookId)).thenReturn(opt);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		assertThat(this.service.update(bookId, currentBook)).isEqualTo(updated);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(bookId);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	void deleteTest() {
		Optional<Book> opt = Optional.of(returned);

		Mockito.when(this.repo.findById(bookId)).thenReturn(opt);
		assertThat(this.service.delete(bookId)).isEqualTo(returned);

		// Verify
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(bookId);
		Mockito.verify(this.repo, Mockito.times(1)).findById(bookId);

	}
}
