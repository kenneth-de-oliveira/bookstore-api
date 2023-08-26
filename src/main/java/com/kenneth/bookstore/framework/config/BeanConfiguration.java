package com.kenneth.bookstore.framework.config;

import com.kenneth.bookstore.BookstoreApplication;
import com.kenneth.bookstore.domain.services.BookService;
import com.kenneth.bookstore.domain.services.CategoryService;
import com.kenneth.bookstore.framework.repository.BookRepository;
import com.kenneth.bookstore.framework.repository.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BookstoreApplication.class})
public class BeanConfiguration {

    @Bean
    public BookService bookService(BookRepository bookRepository, CategoryService categoryService) {
        return new BookService(bookRepository, categoryService);
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }

}
