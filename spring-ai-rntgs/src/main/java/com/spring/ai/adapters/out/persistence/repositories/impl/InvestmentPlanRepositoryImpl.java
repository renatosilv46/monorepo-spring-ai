package com.spring.ai.adapters.out.persistence.repositories.impl;

import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanRequest;
import com.spring.ai.adapters.in.dtos.investment_plan.SaveInvestmentPlanResponse;
import com.spring.ai.adapters.in.dtos.user.CreateUserResponse;
import com.spring.ai.adapters.out.persistence.entities.InvestmentPlanEntity;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;
import com.spring.ai.adapters.out.persistence.repositories.InvestmentPlanPersistence;
import com.spring.ai.application.ports.out.InvestmentPlanRepository;
import com.spring.ai.application.ports.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Repository
public class InvestmentPlanRepositoryImpl implements InvestmentPlanRepository {

    private final InvestmentPlanPersistence investmentPlanPersistence;
    private final UserRepository userRepository;

    public InvestmentPlanRepositoryImpl(InvestmentPlanPersistence investmentPlanPersistence, UserRepository userRepository) {
        this.investmentPlanPersistence = investmentPlanPersistence;
        this.userRepository = userRepository;
    }

    @Override
    public SaveInvestmentPlanResponse saveInvestmentPlan(SaveInvestmentPlanRequest investmentPlanRequest) {

        UserEntity getUser = this.userRepository.getUserById(investmentPlanRequest.userId());

        String investmentPlanBase64 = Base64.getEncoder()
                .encodeToString(investmentPlanRequest.investmentPlanHtml().getBytes());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        InvestmentPlanEntity investmentPlanPrepared = new InvestmentPlanEntity();
        investmentPlanPrepared.setInvestmentPlanHtml(investmentPlanBase64);
        investmentPlanPrepared.setTimestamp(timestamp);
        investmentPlanPrepared.setUser(getUser);

        InvestmentPlanEntity investmentPlanSaved = this.investmentPlanPersistence.save(investmentPlanPrepared);

        CreateUserResponse userResponse = new CreateUserResponse(
            getUser.getUserId(),
            getUser.getUsername(),
            getUser.getName()
        );

        return new SaveInvestmentPlanResponse(
                investmentPlanSaved.getInvestmentPlanId(),
                investmentPlanSaved.getInvestmentPlanHtml(),
                investmentPlanSaved.getTimestamp(),
                userResponse
        );
    }

    @Override
    public List<InvestmentPlanEntity> getAllInvestmentsPlansByUserId(UUID userId) {
        return this.investmentPlanPersistence.findAllByUser_UserId(userId).orElseThrow(() ->
                new RuntimeException("No investment plans found for user with ID: " + userId));
    }
}
