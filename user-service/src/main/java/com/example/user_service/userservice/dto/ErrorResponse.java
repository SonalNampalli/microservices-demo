package com.example.user_service.userservice.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String errorMessage;
    private String httpStatus;

    public ErrorResponse(String errorMessage, String httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
