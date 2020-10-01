package com.clearing;

import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;

import com.clearing.entity.TradeEntity;
import com.clearing.json.CMTrade;
import com.clearing.json.Trade;
import com.clearing.repository.TradeRepository;
import com.clearing.service.TradeService;

public class TradeServiceImplStub implements TradeService {
	
	TradeRepository tradeRepository = new TradeRepositoryStub();
	
	public TradeServiceImplStub() {
		
	}

	@Override
	public List<Trade> getTradesById(int cMId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TradeEntity> generateTrades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TradeEntity createTrade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<HashMap<Integer, Double>, HashMap<Integer, HashMap<Integer, Integer>>> hashMapifyTrades() {
		List<TradeEntity> tradesList = tradeRepository.findAll();
		HashMap<Integer, Double> transactionAmountHashMap = new HashMap<Integer, Double>();
		HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap = new HashMap<Integer, HashMap<Integer, Integer>>();

		for (TradeEntity trade : tradesList) {
			int buyerCMId = trade.getBuyerClearingMember().getClearingMemberId();
			int sellerCMId = trade.getSellerClearingMember().getClearingMemberId();
			int securityId = trade.getSecurityId().getSecurityId();

			if (!transactionAmountHashMap.containsKey(buyerCMId)) {
				transactionAmountHashMap.put(buyerCMId, -1 * trade.getTransactionAmount());
			} else {
				Double updatedTransactionAmount = transactionAmountHashMap.get(buyerCMId) - trade.getTransactionAmount();
				transactionAmountHashMap.put(buyerCMId, updatedTransactionAmount);
			}
			if (!transactionAmountHashMap.containsKey(sellerCMId)) {
				transactionAmountHashMap.put(sellerCMId, trade.getTransactionAmount());
			} else {
				Double updatedTransactionAmount = transactionAmountHashMap.get(sellerCMId)
						+ trade.getTransactionAmount();
				transactionAmountHashMap.put(sellerCMId, updatedTransactionAmount);
			}

			// NEXT HASHMAP
			if (!quantityHashMap.containsKey(buyerCMId)) { // no cm
				HashMap<Integer, Integer> quantityRecord = new HashMap<Integer, Integer>();
				quantityRecord.put(securityId, trade.getQuantity());
				quantityHashMap.put(buyerCMId, quantityRecord);
			} else {
				if (!quantityHashMap.get(buyerCMId).containsKey(securityId)) { // cm but no es
					HashMap<Integer, Integer> quantityRecord = quantityHashMap.get(buyerCMId);
					quantityRecord.put(securityId, trade.getQuantity());
					quantityHashMap.put(buyerCMId, quantityRecord);

				} else { // both
					Integer updatedQuantity = quantityHashMap.get(buyerCMId).get(securityId) + trade.getQuantity();
					quantityHashMap.get(buyerCMId).put(securityId, updatedQuantity);
				}
			}
			if (!quantityHashMap.containsKey(sellerCMId)) {
				HashMap<Integer, Integer> quantityRecord = new HashMap<Integer, Integer>();
				quantityRecord.put(securityId, -1 * trade.getQuantity());
				quantityHashMap.put(sellerCMId, quantityRecord);
			} else {
				if (!quantityHashMap.get(sellerCMId).containsKey(securityId)) {
					HashMap<Integer, Integer> quantityRecord = quantityHashMap.get(sellerCMId);
					quantityRecord.put(securityId, -1 * trade.getQuantity());
					quantityHashMap.put(sellerCMId, quantityRecord);
				} else {
					Integer updatedQuantity = quantityHashMap.get(sellerCMId).get(securityId) - trade.getQuantity();
					quantityHashMap.get(sellerCMId).put(securityId, updatedQuantity);
				}
			}

		}

		return new Pair<HashMap<Integer, Double>, HashMap<Integer, HashMap<Integer, Integer>>>(transactionAmountHashMap,
				quantityHashMap);
	}

	@Override
	public List<CMTrade> getBuyerTradesByCMName(String cMName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CMTrade> getSellerTradesByCMName(String cMName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewTrade(Trade trade) {
		// TODO Auto-generated method stub
		return false;
	}

}