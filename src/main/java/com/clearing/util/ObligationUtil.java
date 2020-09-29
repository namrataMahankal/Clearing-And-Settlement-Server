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
	
	public static Obligation convertToObligation(List<ClearingMemberEntity> memberEntityList, String name) {
		
		for(ClearingMemberEntity memberEntity: memberEntityList) {
			
			Set<EquitySummaryEntity> equityEntities = memberEntity.getEquityEntity();
			
			Map<String,Integer>equities = new HashMap<String, Integer>();
			
			for(EquitySummaryEntity equityEntity: equityEntities) {
				equities.put((equityEntity.getSecurity()).getSecurityName(),equityEntity.getNoOfShares());
		}
	    obligation.setEquityObligation(equities); 
	    obligation.setCMName(name);
	    obligation.setFundObligaton(memberEntity.getNetPayable());
	}
		return obligation;
	
  }
}
