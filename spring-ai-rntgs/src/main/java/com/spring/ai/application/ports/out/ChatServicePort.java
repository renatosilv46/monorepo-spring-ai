package com.spring.ai.application.ports.out;

public interface ChatServicePort {
    String getResponse(String prompt);
    String getResponseWithOptions(String prompt);
}
