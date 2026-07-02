package com.spring.ai.adapters.out.persistence.repositories;

import com.spring.ai.adapters.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPersistence  extends JpaRepository<UserEntity, UUID> {
}
