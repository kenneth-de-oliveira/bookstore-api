package com.kenneth.bookstore.services;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.exceptions.DataIntegrityViolationException;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.mapper.CategoryMapper;
import com.kenneth.bookstore.repositories.CategoryRepository;
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
class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void find_whenToGetId_returnsCategory() {

        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));

        assertDoesNotThrow(() -> {
            service.findById(fake.getId());
        });

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void find_whenToGetId_throwObjetoNotFoundException() {

        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        assertThrows(ObjetoNotFoundException.class, () -> service.findById(fake.getId()));

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void findAll_whenSuccess_returnsCategories() {

        Mockito.when(categoryRepository.findAll()).thenReturn(List.of(getCategory()));

        assertDoesNotThrow(() -> {
            service.findAll();
        });

        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();

    }

    @Test
    void create_whenToGetCategory_returnsSaved() throws NoSuchAlgorithmException {

        var fake = getCategory();

        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(fake);

        var saved = service.create(fake);

        assertNotNull(saved);

        Mockito.verify(categoryRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void update_whenToGetIdAndCategory_returnsUpdated() throws NoSuchAlgorithmException {

        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(fake);

        var updated = service.update(CategoryMapper.mapperToDTO(fake), 1);

        assertNotNull(updated);
        assertEquals(fake.getBooks(), updated.getBooks());
        assertEquals(fake.getDescription(), updated.getDescription());
        assertEquals(fake.getId(), updated.getId());
        assertEquals(fake.getName(), updated.getName());

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(categoryRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void delete_whenToGetId_returnsDeleted() {
        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.doNothing().when(categoryRepository).delete(Mockito.any());

        assertDoesNotThrow(() -> {
            service.delete(fake.getId());
        });

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(categoryRepository, Mockito.times(1)).delete(Mockito.any());

    }

    @Test
    void delete_whenToGetId_throwDataIntegrityViolationException() {
        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.doThrow(new DataIntegrityViolationException("Category cannot be deleted!"))
                .when(categoryRepository).delete(Mockito.any());

        assertThrows(DataIntegrityViolationException.class, () -> {
            service.delete(fake.getId());
        });

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(categoryRepository, Mockito.times(1)).delete(Mockito.any());

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