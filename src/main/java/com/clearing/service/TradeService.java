package com.clearing.service;


import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;

import com.clearing.entity.TradeEntity;
import com.clearing.json.Trade;

public interface TradeService {

	List<Trade> getTradesById(int cMId);
	List<TradeEntity> generateTrades();
	List<Trade> getAllTrades();
	TradeEntity createTrade();
	Pair<HashMap<Integer, Float>, HashMap<Integer, HashMap<Integer, Integer>>> hashMapifyTrades();
}
