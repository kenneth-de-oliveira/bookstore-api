package com.kenneth.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.dtos.BookDTO;
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

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(
			@RequestParam(value = "category", defaultValue = "0") final Integer id) {
		// localhost:8080/book?category=1
		List<Book> list = service.findAll(id);
		List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable final Integer id, @RequestBody Book newBook){
		Book obj = service.update(id, newBook);
		return ResponseEntity.ok().body(obj);
	}
 
}
