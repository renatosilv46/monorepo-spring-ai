package com.spring.ai.application.ports.services;

import com.spring.ai.adapters.in.dtos.InvestmentResponse;

public interface InvestmentServicePort {
    InvestmentResponse createInvestmentPlan(String value, String profile, String period);
}
