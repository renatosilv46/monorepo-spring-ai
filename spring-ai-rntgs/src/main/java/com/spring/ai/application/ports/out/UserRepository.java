package com.spring.ai.application.ports.out;


import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;

import java.util.UUID;

public interface UserRepository {
    UserEntity createUser(CreateUserRequest userRequest);
    UserEntity getUserById(UUID userId);
    UserEntity getUserByUsername(String username);
}
