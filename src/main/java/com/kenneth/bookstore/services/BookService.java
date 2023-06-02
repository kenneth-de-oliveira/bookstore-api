package com.kenneth.bookstore.services;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

	@Autowired
	private CategoryService categoryService;

	public Book findById(final Integer id) {
		Optional<Book> obj = DBService.findBookById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundException(
				"the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName()));
	}

	public List<Book> findAll(final Integer id) {
		categoryService.findById(id);
		return DBService.findAllByCategory(id);
	}

	public Book update(final Integer id, Book book) throws NoSuchAlgorithmException {
		return DBService.updateBook(id, book);
	}

	public void delete(final Integer id) {
		DBService.deleteBookById(id);
	}

	public Book create(final Integer id_cat, Book obj) throws NoSuchAlgorithmException {
		obj.setId(null);
		Category cat = categoryService.findById(id_cat);
		obj.setCategory(cat);
		return DBService.saveBook(obj);
	}

}
