package com.clearing.service;

import java.util.HashMap;
import java.util.List;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.json.CostOfSettlement;
import com.clearing.json.CostOfSettlementFund;
import com.clearing.json.CostOfSettlementShares;
import com.clearing.json.EquitySummary;

public interface ClearingMemberService {
	public void addChangeAfterSettlement(HashMap<Integer, Double> transactionAmountHashMap);

	public double getCMOpeningFundBalance(String cMName);
	public List<EquitySummary> getCMOpeningShareBalance(String cMName);	
	public CostOfSettlementFund getCostOfSettlementFund(String cMName);
	public List<CostOfSettlementShares> getCostOfSettlementShares(String cMName);
	public void calculateFundShortage();
	public List<String> getAllSecurities();
	public List<String> getAllClearingMembers();
	
	public List<CostOfSettlement> getCostOfSettlement();
}
