package com.spring.ai.application.ports.out;

import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanRequest;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanResponse;
import com.spring.ai.adapters.out.persistence.entities.InvestmentPlanEntity;

import java.util.List;
import java.util.UUID;

public interface InvestmentPlanRepository {
    SaveInvestmentPlanResponse saveInvestmentPlan(SaveInvestmentPlanRequest investmentPlanRequest);
    List<InvestmentPlanEntity> getAllInvestmentsPlansByUserId(UUID userId);
}
