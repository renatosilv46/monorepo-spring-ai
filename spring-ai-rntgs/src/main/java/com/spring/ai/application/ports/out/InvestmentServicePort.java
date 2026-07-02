package com.spring.ai.application.ports.out;

import com.spring.ai.adapters.in.dtos.CreateInvestmentPlanResponse;

public interface InvestmentServicePort {
    CreateInvestmentPlanResponse createInvestmentPlan(String value, String profile, String period);
}
