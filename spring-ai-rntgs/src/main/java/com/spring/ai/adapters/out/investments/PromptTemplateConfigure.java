package com.spring.ai.adapters.out.investments;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "prompts.templates")
public class PromptTemplateConfigure {

    private String createInvestmentsPlan;

    public void setCreateInvestmentsPlan(String investmentsPlan) {
        this.createInvestmentsPlan = investmentsPlan;
    }

    public String getCreateInvestmentsPlan(){
        return this.createInvestmentsPlan;
    }
}
