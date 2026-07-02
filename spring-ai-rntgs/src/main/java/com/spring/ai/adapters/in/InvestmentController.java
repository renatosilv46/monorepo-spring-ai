package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.CreateInvestmentPlanResponse;
import com.spring.ai.application.ports.in.CreateInvestmentPlanUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final CreateInvestmentPlanUseCase createInvestmentPlanUseCase;

    public InvestmentController(CreateInvestmentPlanUseCase createInvestmentPlanUseCase) {
        this.createInvestmentPlanUseCase = createInvestmentPlanUseCase;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateInvestmentPlanResponse> createInvestmentPlan(
            @RequestParam String value,
            @RequestParam(defaultValue = "any") String profile,
            @RequestParam String period) {

        CreateInvestmentPlanResponse investmentResponse = this.createInvestmentPlanUseCase.createInvestmentPlan(value, profile, period);
        return ResponseEntity.ok(investmentResponse);
    }
}
