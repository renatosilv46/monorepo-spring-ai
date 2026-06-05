package com.spring.ai.application.usecases;

import com.spring.ai.application.ports.services.AzureStorageServicePort;
import com.spring.ai.application.ports.services.ImageServicePort;
import com.spring.ai.application.ports.usecases.ImageUseCase;
import org.springframework.ai.image.ImageResponse;

public class ImageUseCaseImpl implements ImageUseCase {

    private final ImageServicePort imageService;
    private final AzureStorageServicePort azureStorageService;

    public ImageUseCaseImpl(ImageServicePort imageService, AzureStorageServicePort azureStorageService) {
        this.imageService = imageService;
        this.azureStorageService = azureStorageService;
    }

    @Override
    public String generateImage(String prompt, String quality, Integer quantity, Integer height, Integer width) {

        ImageResponse imageResponse = this.imageService.createImage(prompt, quality, quantity, height, width);

        String imageBase64 = imageResponse.getResult().getOutput().getB64Json();
        byte[] imageBytes = java.util.Base64.getDecoder().decode(imageBase64);

        String imageNameUploaded = this.azureStorageService.uploadImage(imageBytes);
        String signedImageUrl = this.azureStorageService.getSignedUri(imageNameUploaded);

        return signedImageUrl;
    }
}
