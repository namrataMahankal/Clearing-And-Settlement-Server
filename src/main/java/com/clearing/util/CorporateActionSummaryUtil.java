package com.clearing.util;


import java.util.List;






import com.clearing.entity.CorporateActionSummaryEntity;

import com.clearing.json.CorporateActionList;
import com.clearing.json.CorporateActionSummary;


public class CorporateActionSummaryUtil {
	
	public static CorporateActionSummary convertEntityToSummary(List<CorporateActionSummaryEntity> summaryEntityList, String name) {
		
		CorporateActionSummary summary = new CorporateActionSummary();
		summary.setClearingMemberId(name);

		for(CorporateActionSummaryEntity summaryEntity: summaryEntityList) {
			CorporateActionList corpList = new CorporateActionList();
			corpList.setAction(summaryEntity.getAction());
			corpList.setFinalShareBalance(summaryEntity.getFinalShareBalance());
			corpList.setInitialShareBalance(summaryEntity.getInitialShareBalance());
			corpList.setParameter(summaryEntity.getParameter());
			corpList.setSecurityName((summaryEntity.getSecurity()).getSecurityName());
			(summary.getActionList()).add(corpList);			
		}	

		return summary;
	
  }
	
}
