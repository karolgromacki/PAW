package com.example.backend.service.client;

import com.example.backend.entity.dao.client.Payment;
import com.example.backend.entity.dto.client.PaymentShortDto;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    @author Kacper Buczak 
*/
@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private ModelMapper modelMapper;
    private ClientRepository clientRepository;

    public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }

    public List<PaymentShortDto> getPayments() {
        return paymentRepository
                .findAll()
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }

    public List<PaymentShortDto> getPaymentsByClientId(Long clientId) {
        return paymentRepository
                .findAllByClientId(clientId)
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }

    public PaymentShortDto getPaymentByOrderId(Long orderId) {
        return entityToSimpleDTO(paymentRepository.findOneByOrderId(orderId));
    }

    public PaymentShortDto createPayment(PaymentShortDto paymentShortDto, Long clientId) {
        Payment payment = new Payment();
        payment.setAmount(paymentShortDto.getAmount());
        payment.setClient(clientRepository.getOne(clientId));
        payment.setDate(paymentShortDto.getDate());
        payment.setPaymentType(paymentShortDto.getPaymentType());
        return entityToSimpleDTO(paymentRepository.save(payment));
    }

    public PaymentShortDto updatePayment(PaymentShortDto paymentShortDto) {
        Payment payment = paymentRepository.getOne(paymentShortDto.getId());
        payment.setAmount(paymentShortDto.getAmount());
        payment.setDate(paymentShortDto.getDate());
        payment.setPaymentType(paymentShortDto.getPaymentType());
        return entityToSimpleDTO(paymentRepository.save(payment));
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    private PaymentShortDto entityToSimpleDTO(Payment entity) {
        PaymentShortDto entityDto = modelMapper.map(entity, PaymentShortDto.class);
        return entityDto;
    }
}
