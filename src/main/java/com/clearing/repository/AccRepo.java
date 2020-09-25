package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.AccountEntity;

public interface AccRepo extends JpaRepository<AccountEntity, Long> {
   
	List<AccountEntity> findById(long id);
	
}
