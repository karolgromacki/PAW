package com.example.backend.entity.dto.client;

import com.example.backend.entity.dto.BaseDto;
import com.example.backend.entity.dto.product.OrderDto;
import com.example.backend.entity.dto.product.ProductDto;

import java.util.List;

/*
    @author Karol Gromacki 
*/
public class BasketDto extends BaseDto {

    private Long totalAmmount;

    private List<ProductDto> products;

    private ClientShortDto client;

    public BasketDto() {
    }

    public Long getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(Long totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public ClientShortDto getClient() {
        return client;
    }

    public void setClient(ClientShortDto client) {
        this.client = client;
    }
}
