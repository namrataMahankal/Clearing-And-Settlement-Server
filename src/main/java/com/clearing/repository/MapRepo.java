package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clearing.entity.ClearingMemberEntity;

public interface MapRepo extends JpaRepository<ClearingMemberEntity, Integer>{

	List<ClearingMemberEntity> findByClearingMemberName(String name);

}
