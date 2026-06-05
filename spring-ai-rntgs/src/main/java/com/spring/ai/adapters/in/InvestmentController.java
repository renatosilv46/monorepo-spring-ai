package com.spring.ai.adapters.in;

import com.spring.ai.adapters.in.dtos.InvestmentResponse;
import com.spring.ai.application.ports.services.InvestmentServicePort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final InvestmentServicePort investmentServicePort;

    public InvestmentController(InvestmentServicePort investmentServicePort) {
        this.investmentServicePort = investmentServicePort;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvestmentResponse> createInvestmentPlan(
            @RequestParam String value,
            @RequestParam(defaultValue = "any") String profile,
            @RequestParam String period) {

        InvestmentResponse investmentResponse = investmentServicePort.createInvestmentPlan(value, profile, period);
        return ResponseEntity.ok(investmentResponse);
    }
}
