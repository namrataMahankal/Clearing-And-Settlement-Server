package com.clearing.util;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.TradeEntity;
import com.clearing.json.CMTrade;
import com.clearing.json.Trade;

public class TradeUtil {

	public static Trade convertTradeEntityIntoTrade(TradeEntity tradeEntity) {
		return new Trade(tradeEntity.getSecurityId().getSecurityName(), tradeEntity.getQuantity(),
				tradeEntity.getPrice(), tradeEntity.getBuyerClearingMember().getClearingMemberName(),
				tradeEntity.getSellerClearingMember().getClearingMemberName(), tradeEntity.getTransactionAmount());
	}

	public static List<Trade> convertTradeEntityListIntoTradeList(List<TradeEntity> tradeEntityList) {
		List<Trade> trades = new ArrayList<Trade>();
		for (TradeEntity tradeEntity : tradeEntityList) {
			trades.add(convertTradeEntityIntoTrade(tradeEntity));
		}
		return trades;
	}

	public static CMTrade convertTradeEntityIntoCMTrade(TradeEntity tradeEntity) {
		return new CMTrade(tradeEntity.getSecurityId().getSecurityName(), tradeEntity.getQuantity(),
				tradeEntity.getPrice(), tradeEntity.getTransactionAmount());
	}

	public static List<CMTrade> convertTradeEntityListIntoCMTradeList(List<TradeEntity> tradeEntityList) {
		List<CMTrade> trades = new ArrayList<CMTrade>();
		for (TradeEntity tradeEntity : tradeEntityList) {
			trades.add(convertTradeEntityIntoCMTrade(tradeEntity));
		}
		return trades;
	}
}
