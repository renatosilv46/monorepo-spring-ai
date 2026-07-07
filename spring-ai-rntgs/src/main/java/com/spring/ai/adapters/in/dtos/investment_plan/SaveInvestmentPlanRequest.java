package com.spring.ai.adapters.in.dtos.investment_plan;

import java.util.UUID;

public record SaveInvestmentPlanRequest(
        String investmentPlanHtml,
        UUID userId) {
}
