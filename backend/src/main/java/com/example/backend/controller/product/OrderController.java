package com.example.backend.controller.product;

import com.example.backend.entity.dto.product.OrderDto;
import com.example.backend.service.product.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @author Kacper Buczak 
*/
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<OrderDto>> getProductList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getAllOrders());
    }

    @GetMapping(value = "/orders/{basketId}")
    public ResponseEntity<List<OrderDto>> getProductListByBasketId(@PathVariable Long basketId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getOrderByBasketId(basketId));
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderDto> createProduct(@RequestBody OrderDto orderDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.createOrder(orderDto));
    }

    @PutMapping(value = "/orders")
    public ResponseEntity<OrderDto> updateProduct(@RequestBody OrderDto orderDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.updateOrder(orderDto));
    }

    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }

}
