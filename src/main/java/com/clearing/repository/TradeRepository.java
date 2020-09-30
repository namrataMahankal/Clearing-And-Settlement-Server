package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.TradeEntity;



public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {

	List<TradeEntity> findByBuyerClearingMember(ClearingMemberEntity buyerCM);

	List<TradeEntity> findBySellerClearingMember(ClearingMemberEntity sellerCM);
	
}