package com.clearing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.json.CorporateActionSummary;
import com.clearing.repository.CorporateActionSummaryRepo;
import com.clearing.util.CorporateActionSummaryUtil;

@Service
public class CorporateActionServiceImpl implements CorporateActionSummaryService {

	@Autowired
	CorporateActionSummaryRepo corporateActionRepo;
	
	@Override
    public CorporateActionSummary getCorporateActionSummary(int id, String name){
		
		return CorporateActionSummaryUtil.convertEntityToSummary(corporateActionRepo.findByClearingMemberId(id), name); 
		
	}
	
}
