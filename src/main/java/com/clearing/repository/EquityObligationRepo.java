package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clearing.entity.EquitySummaryEntity;

public interface EquityObligationRepo extends JpaRepository<EquitySummaryEntity, Integer>{

	List<EquitySummaryEntity> findByIdClearingMemberId(int id);
}
