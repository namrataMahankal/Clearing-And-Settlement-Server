package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.TradeEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {

	List<TradeEntity> findByBuyerClearingMember(ClearingMemberEntity buyerCM);

	List<TradeEntity> findBySellerClearingMember(ClearingMemberEntity sellerCM);

	// List<Trade> findByBuyerClearingMember

//	@Query("SELECT new com.clearing.entity.TradeEntity(tradeId, securityId, quantity, price, buyerClearingMemberId, sellerClearingMemberId, transactionAmount)"
//			+" from TradeEntity")
//	List<TradeEntity> getAllTradeEntities();

}