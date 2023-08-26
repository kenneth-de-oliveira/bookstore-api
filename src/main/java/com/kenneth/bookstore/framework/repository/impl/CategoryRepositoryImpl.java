package com.kenneth.bookstore.framework.repository.impl;

import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.framework.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class CategoryRepositoryImpl implements com.kenneth.bookstore.domain.repository.CategoryRepository {

    @Autowired
    private CategoryRepository bookRepository;

    @Override
    public Optional<Category> findById(Integer id) {
        return bookRepository.findById(id);
    }

}
