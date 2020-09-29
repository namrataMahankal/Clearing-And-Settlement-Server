package com.clearing.service;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.CorporateActionEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.json.CorporateActionSummary;

public interface CorporateActionService {
	List<CorporateActionEntity> showCorporateActions(); 
	List<CorporateActionSummaryEntity> showCorporateActionsSummary();
	ArrayList<CorporateActionSummaryEntity> applyCorporateActions();
	CorporateActionSummary getCorporateActionSummary(int id, String name);
}