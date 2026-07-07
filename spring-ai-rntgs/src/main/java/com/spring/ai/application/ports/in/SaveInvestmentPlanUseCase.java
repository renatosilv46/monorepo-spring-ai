package com.spring.ai.application.ports.in;

import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanRequest;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanResponse;

public interface SaveInvestmentPlanUseCase {
    SaveInvestmentPlanResponse saveInvestmentPlan(SaveInvestmentPlanRequest investmentPlanRequest);
}
