package com.kenneth.bookstore.mapper;

import com.kenneth.bookstore.dtos.BookDTO;
import com.kenneth.bookstore.factory.BookStoreApiFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMapperTest {

    @Test
    void mapper_whenToGetBookEntity_returnsBookDTO() {

        var fake = BookStoreApiFactory.getBookList().stream().findFirst().get();

        var bookDTO = BookMapper.mapperToDTO(fake);

        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(fake.getTitle(), bookDTO.getTitle());
        Assertions.assertEquals(fake.getAuthorName(), bookDTO.getAuthorName());

    }

    @Test
    void mapper_whenToGetBookDTO_returnsBookEntity() {
        var fake = BookStoreApiFactory.getBookList().stream().findFirst().get();
        var fakeDTO = new BookDTO();
        fakeDTO.setTitle(fake.getTitle());
        fakeDTO.setAuthorName(fake.getAuthorName());

        var book = BookMapper.mapperToEntity(fakeDTO);

        Assertions.assertNotNull(book);
        Assertions.assertEquals(fakeDTO.getTitle(), book.getTitle());
        Assertions.assertEquals(fakeDTO.getAuthorName(), book.getAuthorName());

    }


}