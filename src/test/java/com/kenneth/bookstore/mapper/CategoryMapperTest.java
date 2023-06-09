package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.dtos.CategoryDTO;
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

        var categoryDTO = CategoryMapper.mapperToDTO(fake);

        Assertions.assertNotNull(categoryDTO);
        Assertions.assertEquals(fake.getId(), categoryDTO.getId());
        Assertions.assertEquals(fake.getName(), categoryDTO.getName());
        Assertions.assertEquals(fake.getDescription(), categoryDTO.getDescription());

    }

    @Test
    void mapper_whenToGetCategoryDTO_returnsCategoryEntity() {

        var fakeDTO = getCategoryDTO();

        var category = CategoryMapper.mapperToEntity(fakeDTO);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(fakeDTO.getId(), category.getId());
        Assertions.assertEquals(fakeDTO.getName(), category.getName());
        Assertions.assertEquals(fakeDTO.getDescription(), category.getDescription());

    }

    public CategoryDTO getCategoryDTO() {

        var fake = new CategoryDTO();

        fake.setId(1);
        fake.setName("Informatica");
        fake.setDescription("Livros de TI");

        return fake;
    }

    public Category getCategory() {

        var fake = new Category();

        fake.setId(1);
        fake.setName("Informatica");
        fake.setDescription("Livros de TI");
        fake.setBooks(new ArrayList<>());

        return fake;
    }

}