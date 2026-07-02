package com.spring.ai.adapters.out.persistence.repositories.impl;

import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;
import com.spring.ai.adapters.out.persistence.repositories.UserPersistence;
import com.spring.ai.application.ports.out.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserPersistence userPersistence;

    public UserRepositoryImpl(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    @Override
    public UserEntity createUser(CreateUserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.username());
        userEntity.setName(userRequest.name());

        return this.userPersistence.save(userEntity);
    }
}
