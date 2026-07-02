package com.spring.ai.application.ports.in;

import com.spring.ai.adapters.in.dtos.CreateInvestmentPlanResponse;

public interface CreateInvestmentPlanUseCase {
    CreateInvestmentPlanResponse createInvestmentPlan(String value, String profile, String period);
}
