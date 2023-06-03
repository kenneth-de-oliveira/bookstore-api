package com.kenneth.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    void find_whenToGetId_returnsBook() {

    }

    @Test
    void findAll_whenToGetId_returnsBooks() {

    }

    @Test
    void update_whenToGetIdAndBook_returnsUpdated() throws NoSuchAlgorithmException {

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {

    }

    @Test
    void create_whenToGetIdAndBook_returnsSaved() throws NoSuchAlgorithmException {

    }

}