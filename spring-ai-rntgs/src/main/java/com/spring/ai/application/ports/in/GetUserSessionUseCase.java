package com.spring.ai.application.ports.in;

import com.spring.ai.adapters.in.dtos.user.GetUserSessionResponse;

public interface GetUserSessionUseCase {
    GetUserSessionResponse getUserByUsername(String username);
}
