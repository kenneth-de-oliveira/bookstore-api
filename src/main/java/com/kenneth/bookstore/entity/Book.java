package com.kenneth.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.kenneth.bookstore.jacoco.ExcludeFromJacocoGeneratedReport;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_book")
public class Book implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Enter a title for your Book")
    @Length(min = 3, max = 100, message = "The title field must be 3 to 50 characters long")
    private String title;

    @NotEmpty(message = "Enter the name of the author of the Book")
    @Length(min = 3, max = 100, message = "The author name field must be 3 to 50 characters long")
    private String authorName;

    @NotEmpty(message = "Insert book content")
    @Length(min = 3, max = 2000000, message = "The text field must be 3 to 2000000 characters long")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
        super();
    }

    public Book(Integer id, String title, String authorName, String text, Category category) {
        super();
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.text = text;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ExcludeFromJacocoGeneratedReport
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @ExcludeFromJacocoGeneratedReport
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}