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

	//@Query(value = "Select t.tradId, t.securityId, t.quantity, t.price, 'abc' buyerClearingMember, c.clearingMemberName sellerClearingMember, t.transactionAmount from trade t join clearingMember c",nativeQuery=true)
	//List<Trade> getAllTrades();
	
	List<TradeEntity> findAllByBuyerClearingMemberIdOrSellerClearingMemberId(@Param("buyerid") int buyerCMId,
			@Param("sellerid") int sellerCMId);

}