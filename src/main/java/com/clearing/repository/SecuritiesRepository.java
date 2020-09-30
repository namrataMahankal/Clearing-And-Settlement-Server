package com.clearing.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.clearing.entity.SecuritiesEntity;




public interface SecuritiesRepository extends JpaRepository<SecuritiesEntity, Integer> {
    
	SecuritiesEntity findBySecurityId(int securityId);
	SecuritiesEntity findBySecurityName(String securityName);
}