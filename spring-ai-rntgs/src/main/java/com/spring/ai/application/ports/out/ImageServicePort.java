package com.spring.ai.application.ports.out;

import org.springframework.ai.image.ImageResponse;

public interface ImageServicePort {
    ImageResponse createImage(String prompt, String quality,
                              Integer quantity, Integer height,
                              Integer width);
}
