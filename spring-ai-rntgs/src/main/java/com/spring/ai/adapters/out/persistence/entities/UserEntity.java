package com.spring.ai.adapters.out.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    @Column(unique = true)
    private String username;
    private String name;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<InvestmentPlanEntity> investmentPlans = new ArrayList<>();

    public void addInvestmentPlan(InvestmentPlanEntity plan) {
        this.investmentPlans.add(plan);
        plan.setUser(this);
    }

    public void removeInvestmentPlan(InvestmentPlanEntity plan) {
        investmentPlans.remove(plan);
        plan.setUser(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<InvestmentPlanEntity> getInvestmentPlans() {
        return investmentPlans;
    }
}
