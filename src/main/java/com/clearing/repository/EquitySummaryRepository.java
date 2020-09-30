package com.clearing.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.clearing.entity.EquitySummaryEntity;

import java.util.List;





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EquitySummaryRepository extends JpaRepository<EquitySummaryEntity, Integer> {
   List<EquitySummaryEntity> findByIdClearingMemberId(int cMId);
   List<EquitySummaryEntity> findByIdSecurityId(int securityId);
}