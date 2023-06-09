package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.domain.Book;
import com.kenneth.bookstore.dtos.BookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookMapperTest {

    @Test
    void mapper_whenToGetBookEntity_returnsBookDTO() {

        var fake = getBook();

        var bookDTO = BookMapper.mapperToDTO(fake);

        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(fake.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(fake.getAuthorName(), bookDTO.getAuthorName());

    }

    @Test
    void mapper_whenToGetBookDTO_returnsBookEntity() {
        var fake = getBook();
        var fakeDTO = getBookDTO();

        var book = BookMapper.mapperToEntity(fakeDTO);

        Assertions.assertNotNull(book);
        Assertions.assertEquals(fakeDTO.getTitle(), book.getTitle());
        Assertions.assertEquals(fakeDTO.getAuthorName(), book.getAuthorName());

    }

    private BookDTO getBookDTO() {

        var fake = new BookDTO();

        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");

        return fake;
    }

    private Book getBook() {

        var fake = new Book();

        fake.setTitle("Clean Code");
        fake.setAuthorName("Robert Martins");

        return fake;
    }

}