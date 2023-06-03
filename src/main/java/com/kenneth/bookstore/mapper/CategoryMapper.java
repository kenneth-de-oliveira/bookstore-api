package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.dtos.CategoryDTO;

public class CategoryMapper {

    private CategoryMapper () {}


    public static CategoryDTO mapperToDTO(Category category) {

        var categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());

        return categoryDTO;

    }


    public static Category mapperToEntity(CategoryDTO categoryDTO) {

        var category = new Category();

        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        return category;

    }


}