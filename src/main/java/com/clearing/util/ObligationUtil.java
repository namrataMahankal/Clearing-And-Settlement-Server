package com.clearing.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.json.EquityObligations;
import com.clearing.json.Obligation;

public class ObligationUtil {

	@Autowired
	static Obligation obligation = new Obligation();
	
	
	public static Obligation convertToObligation(List<ClearingMemberEntity> memberEntityList, String name) {
		
		for(ClearingMemberEntity memberEntity: memberEntityList) {
	    obligation.setClearingMemberName(name);
	    obligation.setFundObligaton(memberEntity.getAmountToPay());
	}
		return obligation;
  }
	
	public static List<EquityObligations> convertEquityEntityToObligation(List<EquitySummaryEntity> equityEntityList) {
		
		List<EquityObligations> equityObligationList = new ArrayList<EquityObligations>();
		
		  for(EquitySummaryEntity equityEntity:equityEntityList) {
			  
			  EquityObligations equityObligation = new EquityObligations();
			  
			  equityObligation.setOpeningShareBalance(equityEntity.getNoOfShares());
			  equityObligation.setSecurityName(equityEntity.getSecurity().getSecurityName());
			  equityObligation.setSecurityObligation(equityEntity.getSettlementChange());
			  
			  equityObligationList.add(equityObligation);
			   
		  }
		  
		  return equityObligationList;
	}
	
}
