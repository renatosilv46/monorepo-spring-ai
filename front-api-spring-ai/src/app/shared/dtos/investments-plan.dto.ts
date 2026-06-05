export interface InvesmentsPlanRequestDto {
    profile: string;
    value: string;
    period: string;
}

export interface InvesmentsPlanResponseDto {
    operationId: string;
    planPayload: string;
    timestamp: string;
}