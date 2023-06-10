package com.kenneth.bookstore.service;

import com.kenneth.bookstore.entity.Category;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import com.kenneth.bookstore.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService service;

    @Test
    void find_whenToGetId_returnsCategory() {

        var fake = BookStoreApiFactory.categories.get(1);

        assertDoesNotThrow(() -> {
            service.findById(fake.getId());
        });

    }

    @Test
    void findAll_whenSuccess_returnsCategories() {

        assertDoesNotThrow(() -> {
            service.findAll();
        });

    }

    @Test
    void create_whenToGetCategory_returnsSaved() throws NoSuchAlgorithmException {

        var fake = new Category(1, "Inform�tica 2", "Livros de TI 2");

        var saved = service.create(fake);

        assertNotNull(saved);

    }

    @Test
    void update_whenToGetIdAndCategory_returnsUpdated() throws NoSuchAlgorithmException {

        var fake = new Category(1, "Inform�tica 2", "Livros de TI 2");

        assertDoesNotThrow(() -> {
            service.update(CategoryMapper.mapperToDTO(fake), 1);
        });

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {
        var fake = BookStoreApiFactory.categories.get(1);

        assertDoesNotThrow(() -> {
            service.delete(fake.getId());
        });


    }


}