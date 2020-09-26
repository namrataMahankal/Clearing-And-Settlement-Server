package com.clearing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMember;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.entity.TradeEntity;
import com.clearing.json.Trade;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.SecuritiesRepository;
import com.clearing.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private SecuritiesRepository securitiesRepository;
	@Autowired
	private ClearingMemberRepository cMRepository;

	private static Random rand = new Random(System.currentTimeMillis());
	private List<ClearingMember> allCM;
	private List<SecuritiesEntity> allSecurities;

	@Override
	public List<Trade> getTradesById(int cMId) {
		// TODO Auto-generated method stub
		return tradeRepository.getTradesById(cMId);

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
		SecuritiesEntity security = allSecurities.get(rand.nextInt(15));
		trade.setSecurityId(security);
		trade.setQuantity(1 + rand.nextInt(10000));
		trade.setPrice(security.getMarketPrice());
		int bCMId = rand.nextInt(10);
		trade.setBuyerClearingMember(allCM.get(bCMId));
		int sCMid;
		do {
			sCMid = rand.nextInt(10);
		} while (sCMid == bCMId);
		trade.setSellerClearingMember(allCM.get(sCMid));
		trade.setTransactionAmount(trade.getQuantity() * trade.getPrice());
		return trade;
	}

	@Override
	public List<Trade> getAllTrades() {
		// TODO Auto-generated method stub
		return tradeRepository.getAllTrades();
	}

}
