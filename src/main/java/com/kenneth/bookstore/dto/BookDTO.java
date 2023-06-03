package com.kenneth.bookstore.dto;

import com.kenneth.bookstore.entity.Book;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String authorName;

    public BookDTO() {
        super();
    }

    public BookDTO(Book obj) {
        super();
        this.title = obj.getTitle();
        this.authorName = obj.getAuthorName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}