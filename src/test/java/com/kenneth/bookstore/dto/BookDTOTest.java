package com.kenneth.bookstore.dto;

import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
 class BookDTOTest {

    @Test
    void dto_shouldReturnDataPassedInTheConstructor(){
        Category category  = new Category(1,"name","description");
        var book = new Book(1,"title","authorName","text",category);
       BookDTO bookDTO = new BookDTO(book);
        assertEquals(bookDTO.getTitle(),book.getTitle());
        assertEquals(bookDTO.getAuthorName(),book.getAuthorName());
    }

    @Test
    void dto_shouldReturnTheValueDefinedFor_authorName(){

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorName("authorName");
        String authorName = new String ("authorName");
        assertEquals(authorName,bookDTO.getAuthorName());


    }
    @Test
    void dto_shouldReturnTheValueDefinedFor_title(){

        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("title");

        assertEquals(bookDTO.getTitle(),"title");

    }
}
