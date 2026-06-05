package com.spring.ai.application.ports.services;

public interface AzureStorageServicePort {
    String uploadImage(byte[] imageBytes);
    String getSignedUri(String imageName);
}
