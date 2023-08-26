package com.kenneth.bookstore.framework.repository.impl;

import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.framework.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class BookRepositoryImpl implements com.kenneth.bookstore.domain.repository.BookRepository {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllByCategory(Integer id) {
        return bookRepository.findAllByCategory(id);
    }

}
