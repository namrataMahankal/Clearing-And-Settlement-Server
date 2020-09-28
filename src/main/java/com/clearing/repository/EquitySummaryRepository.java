package com.clearing.repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import com.clearing.entity.EquitySummary;
import com.clearing.entity.EquitySummaryId;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EquitySummaryRepository extends CrudRepository<EquitySummary, Integer> {
    List<EquitySummary> findByClearingMemberId(int clearingMemberId);
    List<EquitySummary> findBySecurityId(int securityId);
}