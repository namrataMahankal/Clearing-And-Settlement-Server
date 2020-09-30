package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

	

import com.clearing.entity.AccountEntity;


public interface AccRepo extends JpaRepository<AccountEntity, Integer> {
	List<AccountEntity> findByUserName(String userName);
}
