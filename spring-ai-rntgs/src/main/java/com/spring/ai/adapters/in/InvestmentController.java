package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.investment_plan.CreateInvestmentPlanResponse;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanRequest;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanResponse;
import com.spring.ai.application.ports.in.CreateInvestmentPlanUseCase;
import com.spring.ai.application.ports.in.SaveInvestmentPlanUseCase;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final CreateInvestmentPlanUseCase createInvestmentPlanUseCase;
    private final SaveInvestmentPlanUseCase saveInvestmentPlanUseCase;

    public InvestmentController(CreateInvestmentPlanUseCase createInvestmentPlanUseCase, SaveInvestmentPlanUseCase saveInvestmentPlanUseCase) {
        this.createInvestmentPlanUseCase = createInvestmentPlanUseCase;
        this.saveInvestmentPlanUseCase = saveInvestmentPlanUseCase;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateInvestmentPlanResponse> createInvestmentPlan(
            @RequestParam String value,
            @RequestParam(defaultValue = "any") String profile,
            @RequestParam String period) {

        CreateInvestmentPlanResponse investmentResponse = this.createInvestmentPlanUseCase.createInvestmentPlan(value, profile, period);
        return ResponseEntity.ok(investmentResponse);
    }

    @PostMapping
    public ResponseEntity<SaveInvestmentPlanResponse> saveInvestmentPlan(@RequestBody @Valid SaveInvestmentPlanRequest saveInvestmentPlanRequest) {
        SaveInvestmentPlanResponse saveInvestmentPlanResponse = this.saveInvestmentPlanUseCase.saveInvestmentPlan(saveInvestmentPlanRequest);
        return ResponseEntity.ok(saveInvestmentPlanResponse);
    }
}
