package com.clearing.controller;

import java.util.HashMap;
import java.util.List;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.TradeEntity;
import com.clearing.json.CMTrade;
import com.clearing.json.Trade;
import com.clearing.service.ClearingMemberService;
import com.clearing.service.CorporateActionService;
import com.clearing.service.EquitySummaryService;
import com.clearing.service.TradeService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/clearing-and-settlement") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins="http://localhost:4200")
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@Autowired
	private EquitySummaryService equitySummaryService;

	@Autowired
	private ClearingMemberService clearingMemberService;

	@Autowired
	private CorporateActionService corporateActionService;

	// Generate Random Trades
	@GetMapping(path = "/trade/generate")
	public @ResponseBody List<Trade> generateTrades() {
		tradeService.generateTrades();
		return tradeService.getAllTrades();
	}

	// Fetch All Trades
	@GetMapping(path = "/trade")
	public @ResponseBody List<Trade> getAllTrades() {
		return tradeService.getAllTrades();
	}

	@GetMapping(path = "/clearing-member/{cmName}/buyer")
	public @ResponseBody List<CMTrade> getBuyerTradesByCMName(@PathVariable("cmName") String cMName) {
		return tradeService.getBuyerTradesByCMName(cMName);
	}

	@GetMapping(path = "/clearing-member/{cmName}/seller")
	public @ResponseBody List<CMTrade> getSellerTradesByCMName(@PathVariable("cmName") String cMName) {
		return tradeService.getSellerTradesByCMName(cMName);
	}

	@GetMapping(path = "/trade/settle")
	public @ResponseBody Pair<HashMap<Integer, Float>, HashMap<Integer, HashMap<Integer, Integer>>> settleTrades() {
		Pair<HashMap<Integer, Float>, HashMap<Integer, HashMap<Integer, Integer>>> obligationHashMap = tradeService
				.hashMapifyTrades();
		HashMap<Integer, Float> transactionAmountHashMap = obligationHashMap.getValue0();
		HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap = obligationHashMap.getValue1();

		// Adding settlementChange to equitySummary Table
		equitySummaryService.addChangeAfterSettlement(quantityHashMap);

		// Adding amountToPay to clearingMember Table
		clearingMemberService.addChangeAfterSettlement(transactionAmountHashMap);

		// Generating shortage information
		clearingMemberService.calculateFundShortage();
		equitySummaryService.calculateESShortage();

		// Applying Corporate Actions
		corporateActionService.applyCorporateActions();

		return obligationHashMap;
	}

}
