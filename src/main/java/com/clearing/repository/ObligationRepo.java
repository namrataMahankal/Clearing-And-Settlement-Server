package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.json.Obligation;

public interface ObligationRepo extends JpaRepository<ClearingMemberEntity, Integer>{


	List<ClearingMemberEntity> findById(int id);
	
}
