package com.spring.ai.adapters.out.persistence.repositories;

import com.spring.ai.adapters.out.persistence.entities.InvestmentPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvestmentPlanPersistence  extends JpaRepository<InvestmentPlanEntity, UUID> {
    Optional<List<InvestmentPlanEntity>> findAllByUser_UserId(UUID userId);
}
