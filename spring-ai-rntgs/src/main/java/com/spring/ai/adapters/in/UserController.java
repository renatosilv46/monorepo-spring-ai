package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.user.CreateUserRequest;
import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;
import com.spring.ai.application.ports.in.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest userRequest) {
        CreateUserResponse response = this.createUserUseCase.createUser(userRequest);
        return ResponseEntity.ok(response);
    }
}
