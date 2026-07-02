package com.spring.ai.application.ports.out;

public interface AzureStorageServicePort {
    String uploadImage(byte[] imageBytes);
    String getSignedUri(String imageName);
}
