package com.clearing.service;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.CorporateActionEntity;
import com.clearing.entity.CorporateActionSummaryEntity;

public interface CorporateActionService {
	List<CorporateActionEntity> showCorporateActions(); 
	List<CorporateActionSummaryEntity> showCorporateActionsSummary();
	ArrayList<CorporateActionSummaryEntity> applyCorporateActions();
}