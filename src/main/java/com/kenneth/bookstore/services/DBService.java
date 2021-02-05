package com.kenneth.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.repositories.BookRepository;
import com.kenneth.bookstore.repositories.CategoryRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public void instaceDatabase() {

		// category
		Category ct1 = new Category(null, "Informática", "Livros de TI");
		Category ct2 = new Category(null, "ficção cientifica", "Livros de ficção cientifica");

		// book
		Book b1 = new Book(null, "Clean Code", "Robert Martins", "Lorem Ipsum", ct1);
		Book b2 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem Ipsum", ct2);
		Book b3 = new Book(null, "Nineteen Eighty-Four", "George Orwell", "Lorem Ipsum", ct2);
		Book b4 = new Book(null, "Neuromancer", "William Gibson", "Lorem Ipsum", ct2);
		Book b5 = new Book(null, "Fahrenheit 451", "Ray Bradbury", "Lorem Ipsum", ct2);

		ct1.getBooks().addAll(Arrays.asList(b1));
		ct2.getBooks().addAll(Arrays.asList(b2, b3, b4, b5));

		// persistence
		this.categoryRepository.saveAll(Arrays.asList(ct1, ct2));
		this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));
	}

}
