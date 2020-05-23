package com.example.backend.entity.dto.product;

import com.example.backend.entity.dao.enums.Category;
import com.example.backend.entity.dto.BaseDto;

/*
    @author Kacper Buczak 
*/
public class ProductDto extends BaseDto {
    private String productName;
    private Long price;
    private String description;
    private Category category;
    private String author;

    public ProductDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
