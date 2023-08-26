package com.kenneth.bookstore.domain.services;

import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.domain.entity.Category;
import com.kenneth.bookstore.domain.exceptions.ObjetoNotFoundException;
import com.kenneth.bookstore.framework.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    public Book findById(final Integer id) {
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNotFoundException(
                "the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName()));
    }

    public List<Book> findAll(final Integer id) {
        categoryService.findById(id);
        return bookRepository.findAllByCategory(id);
    }

    public Book update(final Integer id, Book newBook) {
        Book book = this.findById(id);
        this.updateBook(book, newBook);
        return bookRepository.save(book);
    }

    private void updateBook(Book book, Book newBook) {
        book.setTitle(newBook.getTitle());
        book.setAuthorName(newBook.getAuthorName());
        book.setCategory(newBook.getCategory());
        book.setText(newBook.getText());
    }

    public void delete(final Integer id) {
        this.findById(id);
        bookRepository.deleteById(id);
    }

    public Book create(final Integer id_cat, Book obj) {
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategory(cat);
        return bookRepository.save(obj);
    }

}