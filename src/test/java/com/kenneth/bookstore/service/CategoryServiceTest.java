package com.kenneth.bookstore.service;

import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.domain.exceptions.DataIntegrityViolationException;
import com.kenneth.bookstore.domain.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.domain.mapper.CategoryMapper;
import com.kenneth.bookstore.framework.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void find_whenToGetId_returnsCategory() {

        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(fake));

        assertDoesNotThrow(() -> {
            service.findById(fake.getId());
        });

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(Mockito.anyInt());

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

        // System Under Test  - SUT

        var sut = service.findAll();

        Assertions.assertNotNull(sut);
        assertFalse(sut.isEmpty());

        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();

    }

    @Test
    void create_whenToGetCategory_returnsSaved() {

        var fake = getCategory();

        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(fake);

        var saved = service.create(fake);

        assertNotNull(saved);

        Mockito.verify(categoryRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    void update_whenToGetIdAndCategory_returnsUpdated() {

        var fake = getCategory();

        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(fake));
        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(fake);

        Category update = service.update(CategoryMapper.mapperToDTO(fake), 1);

        assertNotNull(update);

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
