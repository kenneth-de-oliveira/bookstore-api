package com.kenneth.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.domain.repositories.BookRepository;
import com.kenneth.bookstore.domain.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category ct1 = new Category(null, "Informática", "Livros de TI");
		Book b1 = new Book(null, "Clean Code", "Robert Martins", "Lorem Ipsum", ct1);
		ct1.getBooks().addAll(Arrays.asList(b1));
		
		this.categoryRepository.saveAll(Arrays.asList(ct1));
		this.bookRepository.saveAll(Arrays.asList(b1));
	}

}
