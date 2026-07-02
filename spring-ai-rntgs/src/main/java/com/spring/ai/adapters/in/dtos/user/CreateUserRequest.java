package com.spring.ai.adapters.in.dtos.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CreateUserRequest (
        @Nullable
        UUID userId,
        @NotBlank
        String username,
        @NotBlank
        String name) {
}
