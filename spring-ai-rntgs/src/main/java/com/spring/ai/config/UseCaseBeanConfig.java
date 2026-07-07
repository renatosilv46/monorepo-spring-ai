package com.spring.ai.config;

import com.spring.ai.application.ports.in.*;
import com.spring.ai.application.ports.out.*;
import com.spring.ai.application.usecases.*;
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

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCaseImpl(userRepository);
    }

    @Bean
    public SaveInvestmentPlanUseCase saveInvestmentPlanUseCase(InvestmentPlanRepository investmentPlanRepository) {
        return new SaveInvestmentPlanUseCaseImpl(investmentPlanRepository);
    }

    @Bean
    public GetUserSessionUseCase getUserSessionUseCase(
            UserRepository userRepository,
            InvestmentPlanRepository investmentPlanRepository
    ) {
        return new GetUserSessionUseCaseImpl(userRepository, investmentPlanRepository);
    }
}
