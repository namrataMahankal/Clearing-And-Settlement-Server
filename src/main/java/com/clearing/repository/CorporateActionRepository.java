package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.CorporateActionEntity;


public interface CorporateActionRepository extends JpaRepository<CorporateActionEntity, Integer> {

}
