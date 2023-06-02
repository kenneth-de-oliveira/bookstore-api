package com.kenneth.bookstore.services;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	public Category findById(final Integer id) {
		Optional<Category> obj = DBService.findCategoryById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundException(
				"the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName()));
	}

	public List<Category> findAll() {
		return DBService.findCategoryAll();
	}

	public Category create(Category category) throws NoSuchAlgorithmException {
		category.setId(null);
		return DBService.saveCategory(category);
	}

	public Category update(Category newObj, Integer id) throws NoSuchAlgorithmException {
		return DBService.updateCategory(id, newObj);
	}

	public void delete(Integer id) {
		this.findById(id);
		DBService.deleteCategoryById(id);
	}

}
