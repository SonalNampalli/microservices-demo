package com.example.order_service.orderservice.dto;

import com.example.order_service.orderservice.entity.OrderStatus;

import java.math.BigDecimal;

public class OrderResponse {
    private Long id;
    private Long userId;
    private String product;
    private BigDecimal amount;
    private OrderStatus status;

    public OrderResponse(Long id, Long userId, String product, BigDecimal amount, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
