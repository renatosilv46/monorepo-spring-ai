package com.spring.ai.application.ports.services;

public interface ChatServicePort {
    String getResponse(String prompt);
    String getResponseWithOptions(String prompt);
}
