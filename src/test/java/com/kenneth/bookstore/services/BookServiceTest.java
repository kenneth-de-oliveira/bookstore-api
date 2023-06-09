package com.kenneth.bookstore.services;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private CategoryService categoryService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void find_whenToGetId_returnsBook() {

        var fake = getBook();

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));

        var book = service.findById(1);

        assertNotNull(book);
        assertEquals(fake.getId(), book.getId());
        assertEquals(fake.getTitle(), book.getTitle());
        assertEquals(fake.getAuthorName(), book.getAuthorName());
        assertEquals(fake.getText(), book.getText());
        assertEquals(fake.getCategory(), book.getCategory());

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void find_whenToGetId_throwObjetoNotFoundException() {

        var fake = getBook();

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjetoNotFoundException.class, () -> {
            service.findById(1);
        });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());

    }


    @Test
    void findAll_whenToGetId_returnsBooks() {

        var fakeList = List.of(getBook());

        Mockito.when(categoryService.findById(Mockito.any())).thenReturn(getCategory());
        Mockito.when(bookRepository.findAllByCategory(Mockito.any())).thenReturn(List.of(getBook()));

        var bookList = service.findAll(1);

        assertNotNull(bookList);
        assertIterableEquals(fakeList, bookList);

        Mockito.verify(categoryService, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).findAllByCategory(Mockito.any());

    }


    @Test
    void update_whenToGetIdAndBook_returnsUpdated() throws NoSuchAlgorithmException {

        var fake = getBook();

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBook());

        var updated = service.update(1, fake);

        assertNotNull(updated);
        assertEquals(fake.getId(), updated.getId());
        assertEquals(fake.getTitle(), updated.getTitle());
        assertEquals(fake.getAuthorName(), updated.getAuthorName());
        assertEquals(fake.getText(), updated.getText());
        assertEquals(fake.getCategory(), updated.getCategory());

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {

        var fake = getBook();

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.doNothing().when(bookRepository).deleteById(Mockito.any());

        assertDoesNotThrow(() -> {
            service.delete(fake.getId());
        });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(Mockito.any());

    }

    @Test
    void create_whenToGetIdAndBook_returnsSaved() throws NoSuchAlgorithmException {

        var fake = getBook();

        Mockito.when(categoryService.findById(Mockito.any())).thenReturn(getCategory());
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBook());

        var saved = service.create(1, fake);

        assertNotNull(saved);
        assertEquals(getBook().getId(), saved.getId());
        assertEquals(fake.getTitle(), saved.getTitle());
        assertEquals(fake.getAuthorName(), saved.getAuthorName());
        assertEquals(fake.getText(), saved.getText());
        assertEquals(fake.getCategory(), saved.getCategory());

        Mockito.verify(categoryService, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).save(Mockito.any());

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