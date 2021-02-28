package com.kenneth.bookstore.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryService categoryService;

	public Book findById(final Integer id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundException(
				"the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName()));
	}

	public List<Book> findAll(final Integer id) {
		categoryService.findById(id);
		return bookRepository.findAllByCategory(id);
	}

	public Book update(final Integer id, Book newBook) {
		Book book = this.findById(id);
		this.updateBook(book, newBook);
		return bookRepository.save(book);
	}

	private void updateBook(Book book, Book newBook) {
		book.setTitle(newBook.getTitle());
		book.setAuthorName(newBook.getAuthorName());
		book.setCategory(newBook.getCategory());
		book.setText(newBook.getText());
	}

	public void delete(final Integer id) {
		this.findById(id);
		bookRepository.deleteById(id);
	}

	public Book create(@Valid Book book) {
		book.setId(null);
		return bookRepository.save(book);
	}

}
