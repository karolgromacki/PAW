package com.example.backend.entity.dao.product;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.enums.Category;
import com.example.backend.entity.dao.enums.DiscountType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String productName;
    @Min(value = 0)
    private Double price;
    @Size(min = 0, max = 5000)
    private String description;
    private String imageUrl;
    @Enumerated
    private Category category;
    @NotBlank
    private String author;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "discountType")
    private List<DiscountType> discountType;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public List<DiscountType> getDiscountType() {
        return discountType;
    }

    public void setDiscountType(List<DiscountType> discountType) {
        this.discountType = discountType;
    }
}

