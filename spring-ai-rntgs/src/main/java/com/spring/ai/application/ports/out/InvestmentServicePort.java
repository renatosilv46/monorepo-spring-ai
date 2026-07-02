package com.spring.ai.application.ports.out;

import com.spring.ai.adapters.in.dtos.investment_plan.CreateInvestmentPlanResponse;

public interface InvestmentServicePort {
    CreateInvestmentPlanResponse createInvestmentPlan(String value, String profile, String period);
}
