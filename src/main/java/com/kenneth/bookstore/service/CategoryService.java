package com.kenneth.bookstore.service;
import java.util.List;
import java.util.Optional;

import com.kenneth.bookstore.dto.CategoryDTO;
import com.kenneth.bookstore.entity.Category;
import com.kenneth.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenneth.bookstore.exceptions.DataIntegrityViolationException;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

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