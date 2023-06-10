package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dto.BookDTO;
import com.kenneth.bookstore.entity.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookMapperTest {

    @Test
    void mapper_whenToGetBookEntity_returnsBookDTO () {

        // Arrange
        var fake = getBook();

        // Act
        BookDTO bookDTO = BookMapper.mapperToDTO(fake);

        // Assert
        assertEquals(fake.getAuthorName(), bookDTO.getAuthorName());
        assertEquals(fake.getTitle(), bookDTO.getTitle());

    }

    @Test
    void mapper_whenToGetBookDTO_returnsBookEntity () {

        // Arrange
        var fake = getBook();
        var fakeDTO = getBookDTO();

        // Act
        Book book = BookMapper.mapperToEntity(fakeDTO);

        // Assert
        assertEquals(fakeDTO.getAuthorName(), book.getAuthorName());
        assertEquals(fakeDTO.getTitle(), book.getTitle());

    }

    private Book getBook() {

        var fake = new Book();

        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");

        return fake;
    }

    private BookDTO getBookDTO() {

        var fake = new BookDTO();

        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");

        return fake;
    }



}