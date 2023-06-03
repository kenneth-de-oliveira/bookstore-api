package com.kenneth.bookstore.dto;

import com.kenneth.bookstore.entity.Category;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Enter into name")
    @Length(min = 3, max = 100, message = "The name field must be 3 to 100 characters long")
    private String name;

    @NotEmpty(message = "Enter into description")
    @Length(min = 3, max = 100, message = "The description field must be 3 to 100 characters long")
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
