package com.spring.ai.adapters.out.persistence.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "tb_investment_plans")
public class InvestmentPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID investmentPlanId;

    @Column(columnDefinition = "TEXT")
    private String investmentPlanHtml;

    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    public UUID getInvestmentPlanId() {
        return investmentPlanId;
    }

    public void setInvestmentPlanId(UUID investmentPlanId) {
        this.investmentPlanId = investmentPlanId;
    }

    public String getInvestmentPlanHtml() {
        return investmentPlanHtml;
    }

    public void setInvestmentPlanHtml(String investmentPlanHtml) {
        this.investmentPlanHtml = investmentPlanHtml;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
