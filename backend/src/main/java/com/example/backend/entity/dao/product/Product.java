package com.example.backend.entity.dao.product;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.enums.Category;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String productName;
    @Min(value = 0)
    private Long price;
    private String description;
    private String imageUrl;
    @Enumerated
    private Category category;
    @NotBlank
    private String author;

    @ManyToMany(mappedBy = "products")
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
