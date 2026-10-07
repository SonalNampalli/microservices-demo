package com.example.user_service.userservice.service;

import com.example.user_service.userservice.dto.UserRequest;
import com.example.user_service.userservice.dto.UserResponse;
import com.example.user_service.userservice.entity.User;
import com.example.user_service.userservice.exception.UserNotFoundException;
import com.example.user_service.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getEmail());
        return mapToResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return mapToResponse(user);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
