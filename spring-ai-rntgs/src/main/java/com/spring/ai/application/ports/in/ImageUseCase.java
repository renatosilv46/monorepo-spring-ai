package com.spring.ai.application.ports.in;

public interface ImageUseCase {
    String generateImage(String prompt, String quality, Integer quantity, Integer height, Integer width);
}
