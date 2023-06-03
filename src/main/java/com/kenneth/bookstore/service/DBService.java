package com.kenneth.bookstore.service;

import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.entity.Category;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Service
public class DBService {

    private static List<Book> books = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    public static List<Book> findAllByCategory(Integer id) {
        return Objects.requireNonNull(findCategoryById(id)
                .orElse(null)).getBooks();
    }

    public static Optional<Book> findBookById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public static Optional<Category> findCategoryById(Integer id) {
        return categories.stream().filter(category -> category.getId().equals(id))
                .findFirst();
    }

    public static Category saveCategory(Category category) throws NoSuchAlgorithmException {
        ArrayList<Category> categoryArrayList = new ArrayList<>(categories);
        category.setId(SecureRandom.getInstanceStrong().nextInt(Integer.MAX_VALUE));
        categoryArrayList.add(category);
        categories = categoryArrayList;
        return category;
    }

    public static Book saveBook(Book book) throws NoSuchAlgorithmException {
        if (book.getId() == null) {
            book.setId(SecureRandom.getInstanceStrong().nextInt(Integer.MAX_VALUE));
            book.getCategory().getBooks().add(book);
        }
        ArrayList<Book> bookArrayList = new ArrayList<>(books);
        bookArrayList.add(book);
        books = bookArrayList;
        return book;
    }

    public static Book updateBook(Integer id, Book book) throws NoSuchAlgorithmException {
        Book findBook = findBookById(id).orElse(null);
        if (findBook != null) {
            deleteBookById(findBook.getId());
            book.setId(id);
            book.setCategory(findBook.getCategory());
            return saveBook(book);

        }
        throw new ObjetoNotFoundException("the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName());
    }

    public static void deleteBookById(Integer idBook) {
        ArrayList<Book> bookArrayList = new ArrayList<>(books);
        bookArrayList.removeIf(book -> book.getId().equals(idBook));
        books = bookArrayList;

    }

    public static List<Category> findCategoryAll() {
        return categories;
    }

    public static Category updateCategory(Integer id, Category newObj) throws NoSuchAlgorithmException {
        Category findCategory = findCategoryById(id).orElse(null);
        if (findCategory != null) {
            deleteCategoryById(findCategory.getId());
            newObj.setId(id);
            return saveCategory(newObj);
        }
        throw new ObjetoNotFoundException("the object was not found, id:" + id + ", type: " + ObjetoNotFoundException.class.getName());
    }

    public static void deleteCategoryById(Integer id) {
        ArrayList<Category> categoryArrayList = new ArrayList<>(categories);
        categoryArrayList.removeIf(category -> id.equals(category.getId()));
        categories = categoryArrayList;
    }

    @Bean
    public void populatesDatabase() {

        Category ct1 = new Category(1, "Informatica", "Livros de TI");
        Category ct2 = new Category(2, "ficcao cientifica", "Livros de ficcao cientifica");
        Category ct3 = new Category(3, "Terror", "Livros de Terror");

        // book
        Book b1 = new Book(1, "Clean Code", "Robert Martins", "Lorem Ipsum", ct1);
        Book b2 = new Book(2, "I, Robot", "Isaac Asimov", "Lorem Ipsum", ct2);
        Book b3 = new Book(3, "Nineteen Eighty-Four", "George Orwell", "Lorem Ipsum", ct2);
        Book b4 = new Book(4, "Neuromancer", "William Gibson", "Lorem Ipsum", ct2);
        Book b5 = new Book(5, "Fahrenheit 451", "Ray Bradbury", "Lorem Ipsum", ct2);
        Book b6 = new Book(6, "Frankenstein", "Mary Shelley", "Lorem Ipsum", ct3);
        Book b7 = new Book(7, "Dracula", "Bram Stoker", "Lorem Ipsum", ct3);
        Book b8 = new Book(8, "O Chamado de Cthulhu", "H. P. Lovecraft", "Lorem Ipsum", ct3);
        Book b9 = new Book(9, "Engenharia de Software: Uma Abordagem Profissional", "Roger Pressman", "Lorem Ipsum", ct1);
        Book b10 = new Book(10, "Big Data: Como extrair volume, variedade, velocidade e valor da avalanche de informacao cotidiana", "Kenneth Cukier e Viktor Mayer-schonberer", "Lorem Ipsum", ct1);
        Book b11 = new Book(11, "Linux a Biblia: O Mais Abrangente e Definitivo Guia Sobre Linux", "Christopher Negus", "Lorem Ipsum", ct1);

        ct1.getBooks().addAll(Arrays.asList(b1, b9, b10, b11));
        ct2.getBooks().addAll(Arrays.asList(b2, b3, b4, b5));
        ct3.getBooks().addAll(Arrays.asList(b6, b7, b8));

        categories = Arrays.asList(ct1, ct2, ct3);
        books = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11);

    }

}
