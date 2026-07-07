package com.spring.ai.adapters.in.dtos.user;

import com.spring.ai.adapters.in.dtos.investment_plan.InvestmentPlanResponse;

import java.util.List;
import java.util.UUID;

public record GetUserSessionResponse(
        UUID userId,
        String name,
        List<InvestmentPlanResponse> investments) {
}
