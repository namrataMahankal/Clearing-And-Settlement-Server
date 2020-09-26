package com.clearing.service;


import java.util.List;
import com.clearing.entity.TradeEntity;
import com.clearing.json.Trade;

public interface TradeService {

	List<Trade> getTradesById(int cMId);
	List<TradeEntity> generateTrades();
	List<Trade> getAllTrades();
}
