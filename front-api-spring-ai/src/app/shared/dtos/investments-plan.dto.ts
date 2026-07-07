export interface InvestmentsPlanRequestDto {
  profile: string;
  value: string;
  period: string;
}

export interface InvestmentsPlanResponseDto {
  investmentPlanHtml: string;
}
