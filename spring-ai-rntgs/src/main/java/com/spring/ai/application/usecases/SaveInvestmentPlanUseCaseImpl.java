package com.spring.ai.application.usecases;

import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanRequest;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanResponse;
import com.spring.ai.application.ports.in.SaveInvestmentPlanUseCase;
import com.spring.ai.application.ports.out.InvestmentPlanRepository;

public class SaveInvestmentPlanUseCaseImpl implements SaveInvestmentPlanUseCase  {

    private final InvestmentPlanRepository investmentPlanRepository;

    public SaveInvestmentPlanUseCaseImpl(InvestmentPlanRepository investmentPlanRepository) {
        this.investmentPlanRepository = investmentPlanRepository;
    }

    @Override
    public SaveInvestmentPlanResponse saveInvestmentPlan(SaveInvestmentPlanRequest investmentPlanRequest) {
        return this.investmentPlanRepository.saveInvestmentPlan(investmentPlanRequest);
    }
}
