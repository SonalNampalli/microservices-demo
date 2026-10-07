package com.example.user_service.userservice.exception;

import org.springframework.stereotype.Component;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User not found with Id:"+userId);
    }
}
