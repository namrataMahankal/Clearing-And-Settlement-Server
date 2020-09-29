package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.json.EquitySummary;

public interface ClearingMemberService {
    public void addChangeAfterSettlement(HashMap<Integer, Float> transactionAmountHashMap);

	public float getCMOpeningFundBalance(String cMName);
	public List<EquitySummary> getCMOpeningShareBalance(String cMName);	
	public ArrayList<ClearingMemberEntity> calculateFundShortage();
}