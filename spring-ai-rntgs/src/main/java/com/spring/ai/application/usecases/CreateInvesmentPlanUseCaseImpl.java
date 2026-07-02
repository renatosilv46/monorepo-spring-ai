package com.spring.ai.application.usecases;

import com.spring.ai.adapters.in.dtos.investment_plan.CreateInvestmentPlanResponse;
import com.spring.ai.application.ports.in.CreateInvestmentPlanUseCase;
import com.spring.ai.application.ports.out.InvestmentServicePort;

public class CreateInvesmentPlanUseCaseImpl implements CreateInvestmentPlanUseCase {

    private final InvestmentServicePort investmentServicePort;

    public CreateInvesmentPlanUseCaseImpl(InvestmentServicePort investmentServicePort) {
        this.investmentServicePort = investmentServicePort;
    }

    @Override
    public CreateInvestmentPlanResponse createInvestmentPlan(String value, String profile, String period) {
        return this.investmentServicePort.createInvestmentPlan(value, profile, period);
    }
}
