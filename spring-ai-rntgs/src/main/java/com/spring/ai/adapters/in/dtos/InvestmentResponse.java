package com.spring.ai.adapters.in.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public record InvestmentResponse (
        UUID operationId,
        String planPayload,
        Timestamp timestamp) {}
