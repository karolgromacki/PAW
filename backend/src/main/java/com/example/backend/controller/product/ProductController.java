package com.example.backend.controller.product;

/*
    @author Kacper Buczak 
*/

import com.example.backend.entity.dto.product.ProductDto;
import com.example.backend.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDto>> getProductList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductList());
    }

    @PostMapping(value = "/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.createProduct(productDto));
    }

    @PutMapping(value = "/products")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.updateProduct(productDto));
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<List<ProductDto>> updateProductImage() {
        // TODO Implement image upload
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(null);
    }
}
