package com.example.order_service.orderservice.client;

import com.example.order_service.orderservice.dto.UserResponse;
import com.example.order_service.orderservice.exception.UserNotFoundException;
import com.example.order_service.orderservice.exception.UserServiceUnavailableException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class UserClient {

    private final RestClient restClient;
    private final String userServiceUrl;

    public UserClient(
            RestClient restClient,
            @Value("${user-service.url}") String userServiceUrl
    ) {
        this.restClient = restClient;
        this.userServiceUrl = userServiceUrl;
    }

    public UserResponse getUserById(Long userId) {
        try {
            return restClient.get()
                    .uri(userServiceUrl + "/users/" + userId)
                    .retrieve()
                    .body(UserResponse.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new UserNotFoundException(userId);
        } catch (RestClientException exception) {
            throw new UserServiceUnavailableException();
        }
    }
}
