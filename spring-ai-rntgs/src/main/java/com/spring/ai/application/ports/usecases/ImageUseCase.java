package com.spring.ai.application.ports.usecases;

public interface ImageUseCase {
    String generateImage(String prompt, String quality, Integer quantity, Integer height, Integer width);
}
