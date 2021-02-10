package com.kenneth.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.dtos.CategoryDTO;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Integer id) {
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
		this.findById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.kenneth.bookstore.exceptions.DataIntegrityViolationException("Category cannot be deleted!");
		}
	}

}
