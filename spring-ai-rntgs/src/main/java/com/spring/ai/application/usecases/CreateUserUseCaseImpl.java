package com.spring.ai.application.usecases;


import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;
import com.spring.ai.application.ports.in.CreateUserUseCase;
import com.spring.ai.application.ports.out.UserRepository;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        UserEntity userSaved = this.userRepository.createUser(userRequest);
        return new CreateUserResponse(
                userSaved.getUserId(),
                userSaved.getUsername(),
                userSaved.getName()
        );
    }
}
