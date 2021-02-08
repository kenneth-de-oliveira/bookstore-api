package com.kenneth.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kenneth.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
