package com.spring.ai.application.ports.out;


import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;

public interface UserRepository {

    UserEntity createUser(CreateUserRequest userRequest);

}
