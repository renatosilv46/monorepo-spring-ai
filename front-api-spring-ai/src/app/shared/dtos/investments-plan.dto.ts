export interface InvestmentsPlanRequestDto {
    profile: string;
    value: string;
    period: string;
}

export interface InvestmentsPlanResponseDto {
    operationId: string;
    planPayload: string;
    timestamp: string;
}