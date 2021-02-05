package com.kenneth.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kenneth.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
