package com.example.backend.entity.dao.client;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.product.Order;
import com.example.backend.entity.dao.product.Product;

import javax.persistence.*;
import java.util.List;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "basket")
public class Basket extends BaseEntity {
    private Long totalAmmount;

    @ManyToMany
    @JoinTable(
            name = "basket_products",
            joinColumns = @JoinColumn(
                    name = "basket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "products_id", referencedColumnName = "id"))
    private List<Product> products;

    @OneToOne(mappedBy = "basket", fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;

    public Basket() {
    }

    public Long getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(Long totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
