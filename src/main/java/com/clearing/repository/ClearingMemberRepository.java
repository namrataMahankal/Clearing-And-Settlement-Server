package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.ClearingMemberEntity;

public interface ClearingMemberRepository extends JpaRepository<ClearingMemberEntity, Integer> {
	ClearingMemberEntity findByClearingMemberName(String CMName);
	//List<ClearingMemberEntity> findAll();
}
