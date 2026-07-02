package com.spring.ai.application.ports.in;

import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest userRequest);
}
