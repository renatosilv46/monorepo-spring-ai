package com.spring.ai.adapters.in.dtos.investment_plan;

import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;

import java.sql.Timestamp;
import java.util.UUID;

public record SaveInvestmentPlanResponse(
        UUID investmentPlanId,
        String investmentPlanHtml,
        Timestamp timestamp,
        CreateUserResponse user) {
}
