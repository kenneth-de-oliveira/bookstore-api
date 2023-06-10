package com.kenneth.bookstore.dto;

import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
 class CategoryDTOTest {
    @Test
    void dto_shouldReturnDataPassedInTheConstructor(){
        Category category  = new Category(1,"name","description");
        CategoryDTO categoryDTO = new CategoryDTO(category);
        assertEquals(categoryDTO.getId(),category.getId());
        assertEquals(categoryDTO.getName(),category.getName());
        assertEquals(categoryDTO.getDescription(),category.getDescription());
    }

    @Test
    void dto_shouldReturnTheValueDefinedFor_id(){
        var id = parseInt("1");
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(id);
        assertEquals(id,categoryDTO.getId());
    }

    @Test
    void dto_shouldReturnTheValueDefinedFor_name(){
        var name = new String("name");
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(name);
        assertEquals(name,categoryDTO.getName());
    }

    @Test
    void dto_shouldReturnTheValueDefinedFor_description(){
        var description = new String("description");
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescription(description);
        assertEquals(description,categoryDTO.getDescription());
    }
}
