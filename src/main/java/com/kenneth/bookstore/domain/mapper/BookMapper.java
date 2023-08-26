package com.kenneth.bookstore.domain.mapper;

import com.kenneth.bookstore.domain.dto.BookDTO;
import com.kenneth.bookstore.domain.entity.Book;

public class BookMapper {

    private BookMapper () {}

    public static BookDTO mapperToDTO(Book book) {
        var bookDTO = new BookDTO();
        bookDTO.setAuthorName(book.getAuthorName());
        bookDTO.setTitle(book.getTitle());

        return bookDTO;
    }


    public static Book mapperToEntity(BookDTO bookDTO) {
        var book = new Book();
        book.setAuthorName(bookDTO.getAuthorName());
        book.setTitle(bookDTO.getTitle());

        return book;
    }

}
