package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.domain.dto.BookDTO;
import com.kenneth.bookstore.domain.entity.Book;
import com.kenneth.bookstore.domain.mapper.BookMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookMapperTest {

    @Test
    void mapper_whenToGetBookEntity_returnsBookDTO () {

        var fake = getBook();

        assertDoesNotThrow(() -> {
            BookMapper.mapperToDTO(fake);
        });

    }

    @Test
    void mapper_whenToGetBookDTO_returnsBookEntity () {

        var fakeDTO = getBookDTO();

        assertDoesNotThrow(() -> {
            BookMapper.mapperToEntity(fakeDTO);
        });

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