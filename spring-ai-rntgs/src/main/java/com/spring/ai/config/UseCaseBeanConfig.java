package com.spring.ai.config;

import com.spring.ai.application.ports.services.AzureStorageServicePort;
import com.spring.ai.application.ports.services.ImageServicePort;
import com.spring.ai.application.ports.usecases.ImageUseCase;
import com.spring.ai.application.usecases.ImageUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean
    public ImageUseCase imageUseCase(
            ImageServicePort imageServicePort,
            AzureStorageServicePort azureStorageServicePort) {
        return new ImageUseCaseImpl(imageServicePort, azureStorageServicePort);
    }
}
