package com.clearing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clearing.entity.TradeEntity;
import com.clearing.json.Trade;
import com.clearing.repository.SecuritiesRepository;
import com.clearing.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private SecuritiesRepository securitiesRepository;

	private static Random rand = new Random(System.currentTimeMillis());

	@Override
	public List<TradeEntity> getTradesById(int cMId) {
		// TODO Auto-generated method stub
		System.out.println(cMId);
		return tradeRepository.findAllByBuyerClearingMemberIdOrSellerClearingMemberId(cMId, cMId);

	}

	@Override
	public List<TradeEntity> generateTrades() {
		// TODO Auto-generated method stub
		tradeRepository.deleteAll();
		int numTrades = 50; // For now
		List<TradeEntity> randomTrades = new ArrayList<TradeEntity>();

		for (int i = 0; i < numTrades; ++i) {
			TradeEntity newTrade = createTrade();
			randomTrades.add(newTrade);
			System.out.println("total = "+randomTrades.size());
		}

		tradeRepository.saveAll(randomTrades);
		return randomTrades;
	}

	public TradeEntity createTrade() {
		TradeEntity trade = new TradeEntity();
		trade.setSecurityId(1 + rand.nextInt(15));
		trade.setQuantity(1 + rand.nextInt(10000));
		trade.setPrice(	securitiesRepository.findBySecurityId(trade.getSecurityId()).getMarketPrice());
		trade.setBuyerClearingMemberId(1 + rand.nextInt(10));
		int sCMid;
		do {
			sCMid = 1 + rand.nextInt(10);
		} while (sCMid == trade.getBuyerClearingMemberId());
		trade.setSellerClearingMemberId(sCMid);
		trade.setTransactionAmount(trade.getQuantity() * trade.getPrice());
		return trade;
	}

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		List<Trade> allTrades = new ArrayList<Trade>();
		return allTrades;
	}

}
