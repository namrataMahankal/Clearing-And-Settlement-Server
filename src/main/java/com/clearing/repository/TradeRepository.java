package com.clearing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clearing.entity.TradeEntity;
import com.clearing.json.Trade;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {

	@Query("SELECT new com.clearing.json.Trade(t.tradeId, s.securityName, t.quantity, t.price, cm1.clearingMemberName, cm2.clearingMemberName, t.transactionAmount)"
			+" from TradeEntity t join t.buyerClearingMember"
			+" cm1 join t.sellerClearingMember"
			+" cm2 join t.security s")
	List<Trade> getAllTrades();

	@Query("SELECT new com.clearing.json.Trade(t.tradeId, s.securityName, t.quantity, t.price, cm1.clearingMemberName, cm2.clearingMemberName, t.transactionAmount) "
			+"from TradeEntity t join t.buyerClearingMember cm1"
			+" join t.sellerClearingMember cm2"
			+" join t.security s"
			+" where t.buyerClearingMember.clearingMemberId = ?1 or t.sellerClearingMember.clearingMemberId = ?1")
	List<Trade> getTradesById(int cMId);
	
//	@Query("SELECT new com.clearing.entity.TradeEntity(tradeId, securityId, quantity, price, buyerClearingMemberId, sellerClearingMemberId, transactionAmount)"
//			+" from TradeEntity")
//	List<TradeEntity> getAllTradeEntities();

}