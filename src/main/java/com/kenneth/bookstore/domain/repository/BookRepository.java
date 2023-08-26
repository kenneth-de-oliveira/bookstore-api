package com.kenneth.bookstore.domain.repository;

import com.kenneth.bookstore.domain.entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAllByCategory(final Integer id);

}
