package com.clearing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.json.Obligation;

public class ObligationUtil {

	@Autowired
	static Obligation obligation = new Obligation();
	
	public static Obligation convertToObligation(List<ClearingMemberEntity> memberEntityList) {
		
		for(ClearingMemberEntity memberEntity: memberEntityList) {
			Set<EquitySummaryEntity> equityEntities = memberEntity.getEquityEntity();
			Map<Integer,Integer>equities = new HashMap<Integer, Integer>();
			for(EquitySummaryEntity equityEntity: equityEntities) {
				equities.put(equityEntity.getSecurityId(),equityEntity.getNoOfShares());
		}
	    obligation.setEquityObligation(equities); 
	    obligation.setCMId(memberEntity.getClearingMemberId());
	    obligation.setFundObligaton(memberEntity.getAmountToPay());
	}
		return obligation;
	
  }
}
