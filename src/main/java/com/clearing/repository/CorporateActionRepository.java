package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.CorporateAction;


public interface CorporateActionRepository extends JpaRepository<CorporateAction, Integer> {

}
