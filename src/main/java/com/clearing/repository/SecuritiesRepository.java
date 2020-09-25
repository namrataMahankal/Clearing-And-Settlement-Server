package com.clearing.repository;
import org.springframework.data.repository.CrudRepository;

import com.clearing.entity.SecuritiesEntity;

// import com.clearing.Trade;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SecuritiesRepository extends CrudRepository<SecuritiesEntity, Integer> {
    
	SecuritiesEntity findBySecurityId(int securityId);
}