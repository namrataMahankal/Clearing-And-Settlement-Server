package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clearing.entity.AccountEntity;
import com.clearing.json.Account;

public interface AccRepo extends JpaRepository<AccountEntity, Integer> {
   
	List<AccountEntity> findById(int id);
	
}
