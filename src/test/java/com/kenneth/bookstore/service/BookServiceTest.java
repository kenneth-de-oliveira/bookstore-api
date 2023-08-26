package com.kenneth.bookstore.service;

import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.domain.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.framework.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService service;

    @Mock
    private CategoryService categoryService;

    @Mock
    private BookRepository bookRepository;

    private Book fake;

    private List <Book> fakeList;

    @BeforeEach
    void setUp() {

        fake = getBook();

        fakeList = List.of(getBook());

    }

    @Test
    void find_whenToGetId_returnsBook() {

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));

       assertDoesNotThrow(() -> {
           service.findById(1);
       });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void find_whenToGetId_throwObjetoNotFoundException() {

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjetoNotFoundException.class, () -> {
            service.findById(1);
        });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void findAll_whenToGetId_returnsBooks() {

        Mockito.when(categoryService.findById(Mockito.any())).thenReturn(getCategory());
        Mockito.when(bookRepository.findAllByCategory(Mockito.any())).thenReturn(List.of(getBook()));

        assertDoesNotThrow(() -> {
            service.findAll(1);
        });

        Mockito.verify(categoryService, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).findAllByCategory(Mockito.any());

    }

    @Test
    void update_whenToGetIdAndBook_returnsUpdated() {

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBook());

        assertDoesNotThrow(() -> {
            service.update(1, fake);
        });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {

        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.doNothing().when(bookRepository).deleteById(Mockito.any());

        assertDoesNotThrow(() -> {
            service.delete(fake.getId());
        });

        Mockito.verify(bookRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(Mockito.any());

    }

    @Test
    void create_whenToGetIdAndBook_returnsSaved() {

        Mockito.when(categoryService.findById(Mockito.any())).thenReturn(getCategory());
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(getBook());

        assertDoesNotThrow(() -> {
            service.create(1, fake);
        });

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