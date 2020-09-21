package com.example.backend.controller.client;

/*
    @author Kacper Buczak 
*/

import com.example.backend.entity.dto.client.PaymentShortDto;
import com.example.backend.service.client.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/payments")
    public ResponseEntity<List<PaymentShortDto>> getPaymentsList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.getPayments());
    }

    @GetMapping(value = "/payments/client/{clientId}")
    public ResponseEntity<List<PaymentShortDto>> getPaymentsListByBasketId(@PathVariable Long clientId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.getPaymentsByClientId(clientId));
    }

    @GetMapping(value = "/payments/order/{orderId}")
    public ResponseEntity<PaymentShortDto> getPaymentsListByOrderId(@PathVariable Long orderId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentService.getPaymentByOrderId(orderId));
    }

    // @Secured("ROLE_ADMIN")
    @PostMapping(value = "/payments")
    public ResponseEntity<PaymentShortDto> createPayment(@RequestBody PaymentShortDto paymentShortDto, @RequestParam Long clientId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentService.createPayment(paymentShortDto, clientId));
    }

    @PutMapping(value = "/payments")
    public ResponseEntity<PaymentShortDto> updatePayment(@RequestBody PaymentShortDto paymentShortDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentService.updatePayment(paymentShortDto));
    }

    @DeleteMapping(value = "/payments/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }

}
