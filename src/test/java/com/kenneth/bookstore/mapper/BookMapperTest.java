package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dto.BookDTO;
import com.kenneth.bookstore.entity.Book;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    @Test
    void mapper_whenToGetBookEntity_returnsBookDTO () {

        // Arrange
        var fake = BookStoreApiFactory.getBookList().stream().findFirst().get();

        // Act
        BookDTO bookDTO = BookMapper.mapperToDTO(fake);

        // Assert
        assertEquals(fake.getAuthorName(), bookDTO.getAuthorName());
        assertEquals(fake.getTitle(), bookDTO.getTitle());

    }

    @Test
    void mapper_whenToGetBookDTO_returnsBookEntity () {

        // Arrange
        var fake = BookStoreApiFactory.getBookList().stream().findFirst().get();
        var fakeDTO = new BookDTO();
        fakeDTO.setTitle(fake.getTitle());
        fakeDTO.setAuthorName(fake.getAuthorName());

        // Act
        Book book = BookMapper.mapperToEntity(fakeDTO);

        // Assert
        assertEquals(fakeDTO.getAuthorName(), book.getAuthorName());
        assertEquals(fakeDTO.getTitle(), book.getTitle());

    }


}