package com.kenneth.bookstore.resources;

import com.kenneth.bookstore.application.resources.BookResource;
import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.domain.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class BookResourceTest {

    @InjectMocks
    private BookResource bookResource;

    @Mock
    private BookService service;

    private Book fake;

    @BeforeEach
    void setUp() {

        fake = getBook();

    }

    @Test
    void find_whenToGetId_returns200() {

        Mockito.when(service.findById(Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.findById(1);
        });

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

        Mockito.when(service.update(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.update(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).update(Mockito.any(), Mockito.any());

    }

    @Test
    void updatePatch_whenToGetIdAndBook_returns200() {

        Mockito.when(service.update(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.updatePatch(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).update(Mockito.any(), Mockito.any());

    }

    @Test
    void create_whenToGetIdAndBook_returns201() {

        Mockito.when(service.create(Mockito.any(), Mockito.any())).thenReturn(fake);

        assertDoesNotThrow(() -> {
            bookResource.create(1, fake);
        });

        Mockito.verify(service, Mockito.times(1)).create(Mockito.any(), Mockito.any());

    }

    @Test
    void delete_whenToGetId_returns204() {

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