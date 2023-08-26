package com.kenneth.bookstore.framework.config;


import com.kenneth.bookstore.framework.repository.BookRepository;
import com.kenneth.bookstore.framework.repository.CategoryRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {
        BookRepository.class,
        CategoryRepository.class
})
public class DatabaseConfiguration {

}