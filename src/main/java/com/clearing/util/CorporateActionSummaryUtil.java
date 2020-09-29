package com.clearing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.json.CorporateActionList;
import com.clearing.json.CorporateActionSummary;
import com.clearing.json.Obligation;

public class CorporateActionSummaryUtil {
	
	public static CorporateActionSummary convertEntityToSummary(List<CorporateActionSummaryEntity> summaryEntityList, String name) {
		
		CorporateActionSummary summary = new CorporateActionSummary();
		
		for(CorporateActionSummaryEntity summaryEntity: summaryEntityList) {
			CorporateActionList corpList = new CorporateActionList();
			corpList.setAction(summaryEntity.getAction());
			corpList.setFinalShareBalance(summaryEntity.getFinalShareBalance());
			corpList.setInitialShareBalance(summaryEntity.getInitialShareBalance());
			corpList.setParameter(summaryEntity.getParameter());
			corpList.setSecurityName((summaryEntity.getSecurity()).getSecurityName());
			summary.setClearingMemberId(name);
			(summary.getActionList()).add(corpList);			
	}	
		System.out.println(summary.getClearingMemberName());
		return summary;
	
  }
	
}
