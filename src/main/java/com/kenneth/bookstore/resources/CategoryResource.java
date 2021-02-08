package com.kenneth.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenneth.bookstore.domain.Category;
import com.kenneth.bookstore.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(final @PathVariable Integer id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

