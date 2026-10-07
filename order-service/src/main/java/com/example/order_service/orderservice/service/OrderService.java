package com.example.order_service.orderservice.service;

import com.example.order_service.orderservice.client.UserClient;
import com.example.order_service.orderservice.dto.OrderRequest;
import com.example.order_service.orderservice.dto.OrderResponse;
import com.example.order_service.orderservice.dto.UserResponse;
import com.example.order_service.orderservice.entity.Order;
import com.example.order_service.orderservice.entity.OrderStatus;
import com.example.order_service.orderservice.exception.OrderNotFoundException;
import com.example.order_service.orderservice.exception.UserNotFoundException;
import com.example.order_service.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        UserResponse userResponse = userClient.getUserById(orderRequest.getUserId());

        if (userResponse == null) {
            throw new UserNotFoundException(orderRequest.getUserId());
        }

        Order order = new Order(
                orderRequest.getUserId(),
                orderRequest.getProduct(),
                orderRequest.getAmount(),
                OrderStatus.PENDING
        );

        return mapToResponse(orderRepository.save(order));
    }

    public OrderResponse getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        return mapToResponse(order);
    }

    public List<OrderResponse> getAllOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getProduct(),
                order.getAmount(),
                order.getStatus()
        );
    }
}
