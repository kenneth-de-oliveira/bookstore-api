package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dto.CategoryDTO;
import com.kenneth.bookstore.entity.Category;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryMapperTest {

    @Test
    void mapper_whenToGetCategoryEntity_returnsCategoryDTO() {

        // Arrange
        var fake  = BookStoreApiFactory.getCategoryList().stream().findFirst().get();
        // Act
        CategoryDTO categoryDTO = CategoryMapper.mapperToDTO(fake);
        // Assert
        assertEquals(fake.getName(),categoryDTO.getName());
        assertEquals(fake.getId(),categoryDTO.getId());
    }

    @Test
    void mapper_whenToGetCategoryDTO_returnsCategoryEntity() {

        // Arrange
        var fake  = BookStoreApiFactory.getCategoryList().stream().findFirst().get();
        // Act
        var categoryDTO = new CategoryDTO();
        categoryDTO.setId(fake.getId());
        categoryDTO.setName(fake.getName());
        categoryDTO.setDescription(fake.getDescription());

        Category category = CategoryMapper.mapperToEntity(categoryDTO);
        // Assert
        assertEquals(category.getId(),categoryDTO.getId());
        assertEquals(category.getName(),categoryDTO.getName());
        assertEquals(category.getDescription(),categoryDTO.getDescription());

    }

}