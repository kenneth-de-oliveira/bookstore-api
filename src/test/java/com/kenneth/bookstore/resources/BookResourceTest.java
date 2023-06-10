package com.kenneth.bookstore.resources;

import com.kenneth.bookstore.dto.BookDTO;
import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.entity.Category;
import com.kenneth.bookstore.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookResourceTest {

    @InjectMocks
    private BookResource bookResource;

    @Mock
    private BookService service;

    @Test
    void find_whenToGetId_returns200() {

        var fake = getBook();

        Mockito.when(service.findById(Mockito.any())).thenReturn(fake);

        ResponseEntity<BookDTO> response = bookResource.findById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        Mockito.verify(service, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void findAll_whenToGetId_returns200() {

        var fakeList = List.of(getBook());

        Mockito.when(service.findAll(Mockito.any())).thenReturn(fakeList);

        assertDoesNotThrow(() -> {
            bookResource.findAll(1);
        });

        Mockito.verify(service, Mockito.times(1)).findAll(Mockito.any());

    }

    @Test
    void update_whenToGetIdAndBook_returns200() {

        var fake = getBook();

        Mockito.when(service.update(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.update(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).update(Mockito.any(), Mockito.any());

    }

    @Test
    void updatePatch_whenToGetIdAndBook_returns200() {

        var fake = getBook();

        Mockito.when(service.update(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.updatePatch(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).update(Mockito.any(), Mockito.any());

    }

    @Test
    void create_whenToGetIdAndBook_returns201() {

        var fake = getBook();

        Mockito.when(service.create(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.create(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).create(Mockito.any(), Mockito.any());

    }

    @Test
    void delete_whenToGetId_returns204() {

        var fake = getBook();

        Mockito.doNothing().when(service).delete(Mockito.any());

        assertDoesNotThrow(() -> {
            bookResource.delete(fake.getId());
        });

        Mockito.verify(service, Mockito.times(1)).delete(Mockito.any());

    }

    private Book getBook() {

        var fake = new Book();

        fake.setId(1);
        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");
        fake.setCategory(getCategory());
        fake.setText("Lorem Ipsum");

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