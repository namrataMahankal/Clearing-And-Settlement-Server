package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clearing.entity.CorporateActionSummaryEntity;

public interface CorporateActionSummaryRepo extends JpaRepository<CorporateActionSummaryEntity, Integer>{

	//@Query("SELECT * FROM CorporateSummaryActionEntity WHERE clearingMemberId = id")
	List<CorporateActionSummaryEntity> findByClearingMemberId(int id);
}
