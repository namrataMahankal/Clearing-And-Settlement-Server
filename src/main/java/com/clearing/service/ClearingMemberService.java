package com.clearing.service;

import java.util.HashMap;
import java.util.List;

import com.clearing.json.EquitySummary;

public interface ClearingMemberService {
	public void addChangeAfterSettlement(HashMap<Integer, Float> transactionAmountHashMap);

	public float getCMOpeningFundBalance(String cMName);

	public List<EquitySummary> getCMOpeningShareBalance(String cMName);

	public void calculateFundShortage();
}
