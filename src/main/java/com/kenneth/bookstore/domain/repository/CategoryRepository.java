package com.kenneth.bookstore.domain.repository;

import com.kenneth.bookstore.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Integer id);

}