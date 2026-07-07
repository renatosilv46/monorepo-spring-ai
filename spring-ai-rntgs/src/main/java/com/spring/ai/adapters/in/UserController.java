package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;
import com.spring.ai.adapters.in.dtos.user.GetUserSessionResponse;
import com.spring.ai.application.ports.in.CreateUserUseCase;
import com.spring.ai.application.ports.in.GetUserSessionUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserSessionUseCase getUserSessionUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserSessionUseCase getUserSessionUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserSessionUseCase = getUserSessionUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest userRequest) {
        CreateUserResponse response = this.createUserUseCase.createUser(userRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetUserSessionResponse> getUserByUsername(@RequestParam String username) {
        GetUserSessionResponse response = this.getUserSessionUseCase.getUserByUsername(username);
        return ResponseEntity.ok(response);
    }
}
