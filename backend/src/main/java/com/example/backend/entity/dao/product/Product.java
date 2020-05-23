package com.example.backend.entity.dao.product;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.enums.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String productName;
    @Min(value = 0)
    private Long price;
    private String description;
    @Lob
    private Byte[] image;
    @Enumerated
    private Category category;
    @NotBlank
    private String author;

    @ManyToMany(mappedBy = "product")
    private List<Basket> baskets;

    public Product() {
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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
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

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }
}
