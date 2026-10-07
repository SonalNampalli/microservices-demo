package com.example.order_service.orderservice.dto;

import java.math.BigDecimal;

public class OrderRequest {
    private String product;
    private BigDecimal amount;
    private Long userId;

    public OrderRequest() {
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
