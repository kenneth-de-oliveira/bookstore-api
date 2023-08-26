package com.kenneth.bookstore.repository;

import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.framework.repository.BookRepository;
import com.kenneth.bookstore.framework.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findAll_whenToGetId_returnsBooks() {

        Book book = getBook();
        book.setCategory(categoryRepository.save(getCategory()));

        bookRepository.save(book);

        assertDoesNotThrow(() -> {
            bookRepository.findAllByCategory(1);
        });

    }

    private Book getBook() {

        var fake = new Book();

        fake.setId(1);
        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");
        fake.setText("Lorem Ipsum");
        fake.setCategory(new Category());

        return fake;
    }

    private Category getCategory() {

        var category = new Category();

        category.setId(1);
        category.setName("Informatica");
        category.setDescription("Livros de TI");
        category.setBooks(new ArrayList<>());

        return category;
    }

}
