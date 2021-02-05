package com.kenneth.bookstore.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenneth.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
