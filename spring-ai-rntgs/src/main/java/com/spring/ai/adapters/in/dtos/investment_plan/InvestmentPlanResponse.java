package com.spring.ai.adapters.in.dtos.investment_plan;

import java.util.UUID;

public record InvestmentPlanResponse(
        UUID investmentPlanId,
        String investmentPlanHtml,
        String investmentPlanGenerationDate) {
}
