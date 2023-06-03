package com.kenneth.bookstore.factory;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.domain.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookStoreApiFactory {

    public static List<Category> categories;
    public static List<Book> books;

    private BookStoreApiFactory () {
    }

    public static List<Category> getCategoryList() {
        return categories;
    }

    public static List<Book> getBookList() {
        return books;
    }

    @Bean
    public void categories () {

        // category

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

    }

    @Bean
    public void books () {

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

        books = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11);

    }


}