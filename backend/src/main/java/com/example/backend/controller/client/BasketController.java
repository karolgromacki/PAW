package com.example.backend.controller.client;

import com.example.backend.entity.dto.client.BasketDto;
import com.example.backend.service.client.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @author Karol Gromacki 
*/
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BasketController {

    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(value = "/baskets/{clientId}")
    public ResponseEntity<List<BasketDto>> getBasketsByClientId(@PathVariable Long clientId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(basketService.getBasketsByClientId(clientId));
    }

    @PostMapping(value = "/baskets")
    public ResponseEntity<BasketDto> createBasket(@RequestBody BasketDto basketDto, @RequestParam Long clientId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(basketService.createBasket(basketDto, clientId));
    }

    @PutMapping(value = "/baskets")
    public ResponseEntity<BasketDto> updateBasket(@RequestBody BasketDto basketDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(basketService.updateBasket(basketDto));
    }

    @DeleteMapping(value = "/baskets/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
        basketService.deleteBasket(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
