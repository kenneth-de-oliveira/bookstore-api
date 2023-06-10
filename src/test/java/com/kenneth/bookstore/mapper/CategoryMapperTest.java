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

        // Arrange
        var fake = getCategory();
        
        // Act
        var categoryDTO = CategoryMapper.mapperToDTO(fake);

        // Assert
        Assertions.assertNotNull(categoryDTO);
        Assertions.assertEquals(fake.getId(), categoryDTO.getId());
        Assertions.assertEquals(fake.getName(), categoryDTO.getName());
        Assertions.assertEquals(fake.getDescription(), categoryDTO.getDescription());

    }

    @Test
    void mapper_whenToGetCategoryDTO_returnsCategoryEntity() {

        // Arrange
        var fakeDTO = getCategoryDTO();

        // Act
        var category = CategoryMapper.mapperToEntity(fakeDTO);

        // Assert
        Assertions.assertNotNull(category);
        Assertions.assertEquals(fakeDTO.getId(), category.getId());
        Assertions.assertEquals(fakeDTO.getName(), category.getName());
        Assertions.assertEquals(fakeDTO.getDescription(), category.getDescription());

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