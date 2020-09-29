package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.ClearingMemberEntity;

public interface ClearingMemberRepository extends JpaRepository<ClearingMemberEntity, Integer> {
	ClearingMemberEntity findByClearingMemberName(String CMName);
}
