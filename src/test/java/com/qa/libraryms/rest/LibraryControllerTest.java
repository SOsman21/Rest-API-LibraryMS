package com.qa.libraryms.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.libraryms.domain.Book;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:book-schema.sql",
		"classpath:book-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class LibraryControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	@Test
	void createTest() throws Exception {
		// Request
		Book book = new Book("9781234567891", "name2", "edition2", "author2", "genre2", "publisher2", 1);
		String createJSON = this.map.writeValueAsString(book);

		RequestBuilder request = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);

		// Response
		Book savedBook = new Book(2L, "9781234567891", "name2", "edition2", "author2", "genre2", "publisher2", 1);

		String savedJSON = this.map.writeValueAsString(savedBook);

		ResultMatcher status = status().isCreated();
		ResultMatcher body = (ResultMatcher) content().json(savedJSON);

		// Test
		this.mock.perform(request).andExpect(status).andExpect(body);
	}

	@Test
	void readTest() throws Exception {
		// Request
		List<Book> books = new ArrayList<>();
		RequestBuilder request = get("/readAll").contentType(MediaType.APPLICATION_JSON);

		// Response
		Book savedBook = new Book(1L,"9781234567897", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		books.add(savedBook);
		
		String savedJSON = this.map.writeValueAsString(books);

		ResultMatcher status = status().is2xxSuccessful();
		ResultMatcher body = (ResultMatcher) content().json(savedJSON);

		// Test
		this.mock.perform(request).andExpect(status).andExpect(body);
	}
	
	@Test
	void readByIdTest() throws Exception {
		// Request
		Book book = new Book(1L, "9781234567897", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		String savedJSON = this.map.writeValueAsString(book);
		RequestBuilder mockRequest = get("/readById/1");

		// Response
		ResultMatcher status = status().isCreated();
		ResultMatcher body = content().json(savedJSON);

		// Test
		this.mock.perform(mockRequest).andExpect(status).andExpect(body);

	}
	
	@Test
	void deleteTest() throws Exception {
		// Request
		Book book = new Book(1L,"9781234567897", "name1", "edition1", "author1", "genre1", "publisher1", 1);
		String savedJSON = this.map.writeValueAsString(book);
		RequestBuilder mockRequest = delete("/delete/1");

		// Response
		ResultMatcher status = status().isOk();
		ResultMatcher body = content().json(savedJSON);

		// Test
		this.mock.perform(mockRequest).andExpect(status).andExpect(body);

	}

}
