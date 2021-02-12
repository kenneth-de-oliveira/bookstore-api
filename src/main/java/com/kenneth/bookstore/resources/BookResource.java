package com.kenneth.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.services.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookResource {

	@Autowired
	private BookService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(final @PathVariable Integer id) {
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
