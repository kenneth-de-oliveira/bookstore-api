package com.kenneth.bookstore.resources;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.dtos.BookDTO;
import com.kenneth.bookstore.services.BookService;

@CrossOrigin("*")
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
	public ResponseEntity<Book> update(@PathVariable final Integer id, @Valid @RequestBody Book newBook) throws NoSuchAlgorithmException {
		Book obj = service.update(id, newBook);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable final Integer id, @Valid @RequestBody Book newBook) throws NoSuchAlgorithmException {
		Book obj = service.update(id, newBook);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") final Integer id_cat, @Valid @RequestBody Book book) throws NoSuchAlgorithmException {
		book = service.create(id_cat, book);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
