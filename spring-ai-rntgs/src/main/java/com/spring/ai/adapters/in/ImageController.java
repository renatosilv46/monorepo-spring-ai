package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.ImageResponse;
import com.spring.ai.application.ports.in.ImageUseCase;
import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {

   private final ImageUseCase imageUseCase;

    public ImageController(final ImageUseCase imageUseCase) {
        this.imageUseCase = imageUseCase;
    }

    @GetMapping("/create")
    public ResponseEntity<ImageResponse> createImage(
            @RequestParam String prompt,
            @Nullable @RequestParam(defaultValue = "medium") String quality,
            @Nullable @RequestParam(defaultValue = "1") Integer quantity,
            @Nullable @RequestParam(defaultValue = "1024") Integer height,
            @Nullable @RequestParam(defaultValue = "1024") Integer width) throws IOException {

        String signedImageUrl = this.imageUseCase.generateImage(prompt, quality, quantity, height, width);

        return ResponseEntity.ok(new ImageResponse(signedImageUrl));
    }
}
