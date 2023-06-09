package com.kenneth.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenneth.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // SELECT obj.id, obj.title FROM tb_book AS obj WHERE obj.category_id = 3 ORDER BY obj.title;

    @Query("SELECT obj FROM tb_book AS obj WHERE obj.category.id = :id ORDER BY title")
    List<Book> findAllByCategory(@RequestParam(value = "id") final Integer id);

}
