package com.spring.ai.application.usecases;

import com.spring.ai.adapters.in.dtos.investment_plan.InvestmentPlanResponse;
import com.spring.ai.adapters.in.dtos.user.GetUserSessionResponse;
import com.spring.ai.adapters.out.persistence.entities.UserEntity;
import com.spring.ai.application.domain.DateHelper;
import com.spring.ai.application.ports.in.GetUserSessionUseCase;
import com.spring.ai.application.ports.out.InvestmentPlanRepository;
import com.spring.ai.application.ports.out.UserRepository;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class GetUserSessionUseCaseImpl implements GetUserSessionUseCase {

    private final UserRepository userRepository;
    private final InvestmentPlanRepository investmentPlanRepository;

    public GetUserSessionUseCaseImpl(UserRepository userRepository, InvestmentPlanRepository investmentPlanRepository) {
        this.userRepository = userRepository;
        this.investmentPlanRepository = investmentPlanRepository;
    }

    @Override
    public GetUserSessionResponse getUserByUsername(String username) {

        UserEntity getUser = this.userRepository.getUserByUsername(username);
        List<InvestmentPlanResponse> getAllInvestmentsPlan =
                this.investmentPlanRepository.getAllInvestmentsPlansByUserId(getUser.getUserId())
                        .stream().map(investmentPlanEntity ->  {

                        byte[] decodedHtmlBytes = Base64.getDecoder().decode(
                                investmentPlanEntity.getInvestmentPlanHtml()
                        );

                        String decodedHtml = new String(decodedHtmlBytes, StandardCharsets.UTF_8);

                            return new InvestmentPlanResponse(
                                investmentPlanEntity.getInvestmentPlanId(),
                                decodedHtml,
                                DateHelper.formatTimestampToStringDate(
                                        investmentPlanEntity.getTimestamp())
                        );
                        }).toList();

        return new GetUserSessionResponse(
                getUser.getUserId(),
                getUser.getName(),
                getAllInvestmentsPlan
        );
    }
}
