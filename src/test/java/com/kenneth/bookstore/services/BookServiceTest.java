package com.kenneth.bookstore.services;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    void find_whenToGetId_returnsBook() {

        var fake= BookStoreApiFactory.getBookList().get(0);

        var book = service.findById(1);

        assertNotNull(book);
        assertEquals(fake.getId(), book.getId());
        assertEquals(fake.getTitle(), book.getTitle());
        assertEquals(fake.getAuthorName(), book.getAuthorName());
        assertEquals(fake.getText(), book.getText());
        assertEquals(fake.getCategory(), book.getCategory());
    }

    @Test
    void findAll_whenToGetId_returnsBooks() {

        var fakeList = BookStoreApiFactory.getBookList()
                .stream().filter(book -> book.getCategory().getId().equals(1))
                .collect(Collectors.toList());

        var book = service.findAll(1);

        assertNotNull(book);
        assertIterableEquals(fakeList, book);

    }

    @Test
    void update_whenToGetIdAndBook_returnsUpdated() throws NoSuchAlgorithmException {

        var fake= BookStoreApiFactory.getBookList().get(5);

        var updated = service.update(1, fake);

        assertNotNull(updated);
        assertEquals(fake.getId(), updated.getId());
        assertEquals(fake.getTitle(), updated.getTitle());
        assertEquals(fake.getAuthorName(), updated.getAuthorName());
        assertEquals(fake.getText(), updated.getText());
        assertEquals(fake.getCategory(), updated.getCategory());

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {

        var fake= BookStoreApiFactory.getBookList().get(0);

        assertDoesNotThrow(() -> {
            service.delete(fake.getId());
        });

    }

    @Test
    void create_whenToGetIdAndBook_returnsSaved() throws NoSuchAlgorithmException {

        var ct1 = new Category(1, "Informática 2", "Livros de TI 2");
        var fake = new Book(1, "Clean Code 2", "Robert Martins 2", "Lorem Ipsum 2", ct1);

        var saved = service.create(1, fake);

        assertNotNull(saved);
        assertEquals(fake.getId(), saved.getId());
        assertEquals(fake.getTitle(), saved.getTitle());
        assertEquals(fake.getAuthorName(), saved.getAuthorName());
        assertEquals(fake.getText(), saved.getText());
        assertEquals(fake.getCategory(), saved.getCategory());
    }

}