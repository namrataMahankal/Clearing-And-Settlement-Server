package com.clearing.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.clearing.entity.EquitySummaryEntity;

import java.util.List;







public interface EquitySummaryRepository extends JpaRepository<EquitySummaryEntity, Integer> {
   List<EquitySummaryEntity> findByIdClearingMemberId(int cMId);
   List<EquitySummaryEntity> findByIdSecurityId(int securityId);
}