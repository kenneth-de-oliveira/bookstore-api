package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dto.BookDTO;
import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;

public class BookMapper {

    private BookMapper () {}

    public static BookDTO mapperToDTO(Book book) {
        var bookDTO = new BookDTO();
        bookDTO.setAuthorName(book.getAuthorName());

//        return bookDTO;
//        bookDTO.setTitle(book.getTitle());
        throw new ObjetoNotFoundException("");


    }


    public static Book mapperToEntity(BookDTO bookDTO) {
        var book = new Book();
        book.setAuthorName(bookDTO.getAuthorName());
        book.setTitle(bookDTO.getTitle());

        return book;
    }

}
