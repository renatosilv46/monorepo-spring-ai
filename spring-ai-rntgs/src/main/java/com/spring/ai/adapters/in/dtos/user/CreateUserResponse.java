package com.spring.ai.adapters.in.dtos.user;

import java.util.UUID;

public record CreateUserResponse(
        UUID userId,
        String username,
        String name) {
}
