package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.clearing.entity.CorporateActionSummaryEntity;


public interface CorporateActionSummaryRepository extends JpaRepository<CorporateActionSummaryEntity, Integer> {

    //@Query("SELECT * FROM CorporateSummaryActionEntity WHERE clearingMemberId = id")
    // List<CorporateActionSummaryEntity> findByClearingMemberId(int id);
    
    List<CorporateActionSummaryEntity> findByIdClearingMemberId(int cmId);
}
