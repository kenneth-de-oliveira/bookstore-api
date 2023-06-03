package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dtos.CategoryDTO;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryMapperTest {


    @Test
    void mapper_whenToGetCategoryEntity_returnsCategoryDTO() {

        var fake = BookStoreApiFactory.getCategoryList().stream().findFirst().get();

        var categoryDTO = CategoryMapper.mapperToDTO(fake);

        Assertions.assertNotNull(categoryDTO);
        Assertions.assertEquals(fake.getId(), categoryDTO.getId());
        Assertions.assertEquals(fake.getName(), categoryDTO.getName());
        Assertions.assertEquals(fake.getDescription(), categoryDTO.getDescription());

    }

    @Test
    void mapper_whenToGetCategoryDTO_returnsCategoryEntity() {

        var fake = BookStoreApiFactory.getCategoryList().stream().findFirst().get();
        var fakeDTO = new CategoryDTO();
        fakeDTO.setId(fake.getId());
        fakeDTO.setDescription(fake.getDescription());
        fakeDTO.setName(fake.getName());

        var category = CategoryMapper.mapperToEntity(fakeDTO);

        Assertions.assertNotNull(category);
        Assertions.assertEquals(fakeDTO.getId(), category.getId());
        Assertions.assertEquals(fakeDTO.getName(), category.getName());
        Assertions.assertEquals(fakeDTO.getDescription(), category.getDescription());

    }


}