package com.kenneth.bookstore.domain.services;

import com.kenneth.bookstore.domain.dto.CategoryDTO;
import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.domain.exceptions.DataIntegrityViolationException;
import com.kenneth.bookstore.domain.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.framework.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(final Integer id) {
       Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNotFoundException(
                "the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName()));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }

    public Category update(CategoryDTO newObj, Integer id) {
        Category objUpdate = this.findById(id);
        objUpdate.setName(newObj.getName());
        objUpdate.setDescription(newObj.getDescription());
        return categoryRepository.save(objUpdate);
    }

    public void delete(Integer id) {
        Category category = this.findById(id);
        try {
            categoryRepository.delete(category);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Category cannot be deleted!");
        }
    }

}