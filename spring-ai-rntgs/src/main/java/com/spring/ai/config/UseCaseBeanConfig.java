package com.spring.ai.config;

import com.spring.ai.application.ports.in.CreateInvestmentPlanUseCase;
import com.spring.ai.application.ports.out.AzureStorageServicePort;
import com.spring.ai.application.ports.out.ImageServicePort;
import com.spring.ai.application.ports.in.ImageUseCase;
import com.spring.ai.application.ports.out.InvestmentServicePort;
import com.spring.ai.application.usecases.CreateInvesmentPlanUseCaseImpl;
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

    @Bean
    public CreateInvestmentPlanUseCase createInvestmentPlanUseCase(
            InvestmentServicePort investmentServicePort
    ) {
        return new CreateInvesmentPlanUseCaseImpl(investmentServicePort);
    }
}
