package com.example.backend.service.product;

import com.example.backend.entity.dao.product.Product;
import com.example.backend.entity.dto.product.ProductDto;
import com.example.backend.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    @author Karol Gromacki 
*/
@Service
public class ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getProductList() {
        return productRepository
                .findAll()
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }


    public ProductDto getProductById(Long id) {
        return this.entityToSimpleDTO(productRepository.getOne(id));
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setAuthor(productDto.getAuthor());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setProductName(productDto.getProductName());
        product.setImageUrl(productDto.getImageUrl());
        product.setBaskets(null);

        return this.entityToSimpleDTO(productRepository.save(product));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.getOne(productDto.getId());
        product.setAuthor(productDto.getAuthor());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setProductName(productDto.getProductName());
        product.setImageUrl(productDto.getImageUrl());
        product.setBaskets(null);

        return this.entityToSimpleDTO(productRepository.save(product));
    }

    public ProductDto updateImage(Long productId) {
        return null;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    private ProductDto entityToSimpleDTO(Product entity) {
        ProductDto entityDto = modelMapper.map(entity, ProductDto.class);
        return entityDto;
    }

}
