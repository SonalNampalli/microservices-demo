package com.example.order_service.orderservice.dto;

public class ErrorResponse {
    private String error;
    private String status;

    public ErrorResponse(String error, String status) {
        this.error = error;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }
}
