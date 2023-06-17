package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dto.CategoryDTO;
import com.kenneth.bookstore.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class CategoryMapperTest {

    @Test
    void mapper_whenToGetCategoryEntity_returnsCategoryDTO() {

        var fake = getCategory();

        Assertions.assertDoesNotThrow(() -> {
            CategoryMapper.mapperToDTO(fake);
        });

    }

    @Test
    void mapper_whenToGetCategoryDTO_returnsCategoryEntity() {

        var fakeDTO = getCategoryDTO();

        Assertions.assertDoesNotThrow(() -> {
            CategoryMapper.mapperToEntity(fakeDTO);
        });

    }

    private Category getCategory() {
        var fake = new Category();

        fake.setId(1);
        fake.setName("Informatica");
        fake.setDescription("Livros de TI");
        fake.setBooks(new ArrayList<>());

        return fake;

    }

    public CategoryDTO getCategoryDTO() {

        var fake = new CategoryDTO();

        fake.setId(1);
        fake.setName("Informatica");
        fake.setDescription("Livros de TI");

        return fake;
    }

}