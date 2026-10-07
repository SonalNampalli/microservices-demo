package com.example.order_service.orderservice.exception;

public class UserServiceUnavailableException extends RuntimeException {
    public UserServiceUnavailableException() {
        super("User service is currently unavailable");
    }
}
