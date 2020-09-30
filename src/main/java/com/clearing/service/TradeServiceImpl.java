package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.entity.TradeEntity;
import com.clearing.json.CMTrade;
import com.clearing.json.Trade;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.SecuritiesRepository;
import com.clearing.repository.TradeRepository;
import com.clearing.util.TradeUtil;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private SecuritiesRepository securitiesRepository;
	@Autowired
	private ClearingMemberRepository cMRepository;

	private static Random rand = new Random(System.currentTimeMillis());
	private List<ClearingMemberEntity> allCM;
	private List<SecuritiesEntity> allSecurities;

	private TradeServiceImpl() {

	}

	@Override
	public List<Trade> getTradesById(int cMId) {
		// TODO Auto-generated method stub
		return null;// tradeRepository.getTradesById(cMId);

	}

	@Override
	public List<TradeEntity> generateTrades() {
		// TODO Auto-generated method stub
		tradeRepository.deleteAll();
		allCM = cMRepository.findAll();
		allSecurities = securitiesRepository.findAll();
		int numTrades = 50; // For now
		List<TradeEntity> randomTrades = new ArrayList<TradeEntity>();

		for (int i = 0; i < numTrades; ++i) {
			TradeEntity newTrade = createTrade();
			randomTrades.add(newTrade);
		}
		tradeRepository.saveAll(randomTrades);
		return randomTrades;
	}

	public TradeEntity createTrade() {
		TradeEntity trade = new TradeEntity();
		SecuritiesEntity security = allSecurities.get(rand.nextInt(allSecurities.size()));
		trade.setSecurityId(security);
		trade.setQuantity(1 + rand.nextInt(10000));
		trade.setPrice(security.getMarketPrice());
		ClearingMemberEntity bCM = allCM.get(rand.nextInt(allCM.size()));
		trade.setBuyerClearingMember(bCM);
		int bCMId = bCM.getClearingMemberId();
		ClearingMemberEntity sCM;
		int sCMid;
		do {
			sCM = allCM.get(rand.nextInt(allCM.size()));
			sCMid = sCM.getClearingMemberId();
		} while (sCMid == bCMId);
		trade.setSellerClearingMember(sCM);
		trade.setTransactionAmount(trade.getQuantity() * trade.getPrice());
		return trade;
	}

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		return (TradeUtil.convertTradeEntityListIntoTradeList(tradeRepository.findAll()));
	}

	public Pair<HashMap<Integer, Float>, HashMap<Integer, HashMap<Integer, Integer>>> hashMapifyTrades() {
		Iterable<TradeEntity> tradesList = tradeRepository.findAll();
		HashMap<Integer, Float> transactionAmountHashMap = new HashMap<Integer, Float>();
		HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap = new HashMap<Integer, HashMap<Integer, Integer>>();

		for (TradeEntity trade : tradesList) {
			int buyerCMId = trade.getBuyerClearingMember().getClearingMemberId();
			int sellerCMId = trade.getSellerClearingMember().getClearingMemberId();
			int securityId = trade.getSecurityId().getSecurityId();

			if (!transactionAmountHashMap.containsKey(buyerCMId)) {
				transactionAmountHashMap.put(buyerCMId, -1 * trade.getTransactionAmount());
			} else {
				Float updatedTransactionAmount = transactionAmountHashMap.get(buyerCMId) - trade.getTransactionAmount();
				transactionAmountHashMap.put(buyerCMId, updatedTransactionAmount);
			}
			if (!transactionAmountHashMap.containsKey(sellerCMId)) {
				transactionAmountHashMap.put(sellerCMId, trade.getTransactionAmount());
			} else {
				Float updatedTransactionAmount = transactionAmountHashMap.get(sellerCMId)
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

		return new Pair<HashMap<Integer, Float>, HashMap<Integer, HashMap<Integer, Integer>>>(transactionAmountHashMap,
				quantityHashMap);

	}

	@Override
	public List<CMTrade> getBuyerTradesByCMName(String cMName) {
		// TODO Auto-generated method stub
		ClearingMemberEntity cm = cMRepository.findByClearingMemberName(cMName);
		return TradeUtil.convertTradeEntityListIntoCMTradeList(tradeRepository.findByBuyerClearingMember(cm));
	}

	@Override
	public List<CMTrade> getSellerTradesByCMName(String cMName) {
		// TODO Auto-generated method stub
		ClearingMemberEntity cm = cMRepository.findByClearingMemberName(cMName);
		return TradeUtil.convertTradeEntityListIntoCMTradeList(tradeRepository.findBySellerClearingMember(cm));
	}

	@Override
	public boolean addNewTrade(Trade trade) {
		// TODO Auto-generated method stub
		try {
			ClearingMemberEntity cMBuyer = cMRepository.findByClearingMemberName(trade.getBuyerCM());
			ClearingMemberEntity cMSeller = cMRepository.findByClearingMemberName(trade.getSellerCM());
			SecuritiesEntity security = securitiesRepository.findBySecurityName(trade.getES());
			TradeEntity tradeEntity = TradeUtil.convertTradeIntoTradeEntity(trade, cMBuyer, cMSeller, security);
			tradeRepository.save(tradeEntity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
