package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.clearing.entity.CorporateActionSummaryEntity;


public interface CorporateActionSummaryRepository extends JpaRepository<CorporateActionSummaryEntity, Integer> {
    List<CorporateActionSummaryEntity> findByClearingMemberId(int id);
}
