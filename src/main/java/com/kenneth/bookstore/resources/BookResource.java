package com.kenneth.bookstore.resources;

import com.kenneth.bookstore.dto.BookDTO;
import com.kenneth.bookstore.mapper.BookMapper;
import com.kenneth.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.kenneth.bookstore.entity.Book;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/book")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(final @PathVariable Integer id) {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(BookMapper.mapperToDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(
            @RequestParam(value = "category", defaultValue = "0") final Integer id) {
        // localhost:8080/book?category=1
        List<Book> list = service.findAll(id);
        List<BookDTO> listDTO = list.stream().map(BookMapper::mapperToDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable final Integer id, @Valid @RequestBody Book newBook) {
        Book obj = service.update(id, newBook);
        return ResponseEntity.ok().body(BookMapper.mapperToDTO(obj));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<BookDTO> updatePatch(@PathVariable final Integer id, @Valid @RequestBody Book newBook) {
        Book obj = service.update(id, newBook);
        return ResponseEntity.ok().body(BookMapper.mapperToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestParam(value = "category", defaultValue = "0") final Integer id_cat, @Valid @RequestBody Book book) {
        book = service.create(id_cat, book);
        return new ResponseEntity<>(BookMapper.mapperToDTO(book), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}