package com.example.backend.service.product;

import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.client.Payment;
import com.example.backend.entity.dao.product.Order;
import com.example.backend.entity.dto.client.BasketDto;
import com.example.backend.entity.dto.client.PaymentShortDto;
import com.example.backend.entity.dto.product.OrderDto;
import com.example.backend.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    @author Karol Gromacki 
*/
@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getOrderByBasketId(Long basketId) {
        return orderRepository
                .getAllOrderByBasketId(basketId)
                .stream()
                .map(this::entityToSimpleDTO)
                .collect(Collectors.toList());
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();

        order.setPayment(paymentMapper(orderDto.getPayment()));
        order.setDate(orderDto.getDate());
        order.setBasket(basketMapper(orderDto.getBasket()));

        return entityToSimpleDTO(orderRepository.save(order));
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        Order orderToUpdate = orderRepository.getOne(orderDto.getId());
        orderToUpdate.setDate(orderDto.getDate());
        return entityToSimpleDTO(orderRepository.save(orderToUpdate));
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    private OrderDto entityToSimpleDTO(Order entity) {
        OrderDto entityDto = modelMapper.map(entity, OrderDto.class);
        return entityDto;
    }

    private Payment paymentMapper(PaymentShortDto entity) {
        Payment entityDto = modelMapper.map(entity, Payment.class);
        return entityDto;
    }

    private Basket basketMapper(BasketDto entity) {
        Basket entityDto = modelMapper.map(entity, Basket.class);
        return entityDto;
    }
}
