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

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductDto> getProductByProductId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
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
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(null);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
