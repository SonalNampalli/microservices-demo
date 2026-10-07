package com.example.user_service.userservice.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String email) {
        super("User with email " + email + " already exists.");
    }
}
