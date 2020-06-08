package com.example.backend.service.client;

import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.product.Product;
import com.example.backend.entity.dto.client.BasketDto;
import com.example.backend.entity.dto.product.ProductDto;
import com.example.backend.repository.BasketRepository;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    @author Kacper Buczak 
*/
@Service

public class BasketService {
    private BasketRepository basketRepository;
    private ClientRepository clientRepository;
    private ProductService productService;
    private ModelMapper modelMapper;

    public BasketService(BasketRepository basketRepository, ClientRepository clientRepository, ProductService productService, ModelMapper modelMapper) {
        this.basketRepository = basketRepository;
        this.clientRepository = clientRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public List<BasketDto> getBasketsByClientId(Long clientId) {
        return basketRepository
                .getBasketsByUser(clientId)
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }

    public BasketDto createBasket(BasketDto basketDto, Long clientId) {
        Basket basket = new Basket();
        basket.setClient(clientRepository.getOne(basketDto.getClient().getId()));
        basket.setProducts(
                basketDto
                        .getProducts()
                        .stream()
                        .map(this::productMapper)
                        .collect(Collectors.toList()));
        basket.setTotalAmmount(basketDto.getTotalAmmount());
        basket.setClient(clientRepository.getOne(clientId));
        return entityToSimpleDTO(basketRepository.save(basket));
    }

    public BasketDto updateBasket(BasketDto basketDto) {
        Basket basket = basketRepository.getOne(basketDto.getId());
        basket.setClient(clientRepository.getOne(basketDto.getClient().getId()));
        basketDto.getProducts().forEach(productDto -> {
            productService.updateProduct(productDto);
        });
        basket.setTotalAmmount(basketDto.getTotalAmmount());
        return entityToSimpleDTO(basketRepository.save(basket));
    }

    public void deleteBasket(Long basketId) {
        basketRepository.deleteById(basketId);
    }

    private BasketDto entityToSimpleDTO(Basket entity) {
        BasketDto entityDto = modelMapper.map(entity, BasketDto.class);
        return entityDto;
    }

    private Product productMapper(ProductDto entity) {
        Product entityDto = modelMapper.map(entity, Product.class);
        return entityDto;
    }
}
